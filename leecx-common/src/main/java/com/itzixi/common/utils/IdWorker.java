package com.itzixi.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @Title: IdWorker.java
 * @Package com.lee.utils
 * @Description: 主键id号生成工具类
 * 					调用方法:
 * 					IdWorker id = new IdWorker();
					id.nextId("");
				
				使用优势:	1. 若自增数据备份恢复有风险, 恢复时有可能出现相同ID
						2. 若uuid字符串性能效率低下
						3. 若自增在数据库分库分表的时候有可能出现相同ID
				
 * Copyright: Copyright (c) 2016
 * Company:Nathan.Lee.Salvatore
 * 
 * @author leechenxiang
 * @date 2016年4月22日 下午8:01:08
 * @version V1.0
 */
public class IdWorker {
	
	private static Logger logger = LoggerFactory.getLogger(IdWorker.class);
	
	private long workerId;
	private long datacenterId;
	private long sequence = 0L;
	
	// 滤波器,使时间变小,生成的总位数变小,一旦确定不能变动
	private long twepoch = 1288834974657L;

	/** 机器标识位数 **/
	private long workerIdBits = 5L;
	/** 数据中心标识位数 **/
	private long datacenterIdBits = 5L;
	/** 机器ID最大值 **/
	private long maxWorkerId = -1L ^ (-1L << workerIdBits);
	/** 数据中心ID最大值 **/
	private long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
	/** 毫秒内自增位 **/
	private long sequenceBits = 12L;
	/** 机器ID偏左移12位 **/
	private long workerIdShift = sequenceBits;
	/** 数据中心ID左移17位 **/
	private long datacenterIdShift = sequenceBits + workerIdBits;
	/** 时间毫秒左移22位 **/
	private long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
	private long sequenceMask = -1L ^ (-1L << sequenceBits);

	private long lastTimestamp = -1L;
	
	/** 上缴批次前缀 **/
	public static final String PREFIX_TRUNOVER = "SJ";
	/** 下发批次前缀 **/
	public static final String PREFIX_ISSUECARD = "XF";
	/** 批量售卡批次前缀 **/
    public static final String PREFIX_BATCH_CARDSELL="PSK";
	/** 卡文本直接充值前缀 **/
    public static final String CARDTEXT_RECHARGE="KWBZJ";
	/** 账户号前缀 **/
    public static final String PREFIX_ACCOUNT_NUM="AC";
    /** 卡文本充值文件名前缀 **/
    public static final String CARDTEXT_RECHARGE_FILENAME="FN";

	public IdWorker() {
		super();
	}

	public IdWorker(long workerId, long datacenterId) {
		// sanity check for workerId
		if (workerId > maxWorkerId || workerId < 0) {
			throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
		}
		if (datacenterId > maxDatacenterId || datacenterId < 0) {
			throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
		}
		this.workerId = workerId;
		this.datacenterId = datacenterId;
		logger.info(String.format("worker starting. timestamp left shift %d, datacenter id bits %d, worker id bits %d, sequence bits %d, workerid %d",
				timestampLeftShift, datacenterIdBits, workerIdBits,
				sequenceBits, workerId));
	}

	/**
	 * 生成并且返回ID号的规则
	 * 
	 * @param prefix ID号前缀, 用于标识ID好是哪种类型的 
	 * 				  可以为空, 为空则忽略此前缀
	 * @return
	 */
	public synchronized String nextId(String prefix) {
		long timestamp = timeGen();
		if (timestamp < lastTimestamp) {
			logger.error(String.format("clock is moving backwards. Rejecting requests until %d.", lastTimestamp));
			throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
		}

		if (lastTimestamp == timestamp) {
			// 当前毫秒内，则+1 
			sequence = (sequence + 1) & sequenceMask;
			if (sequence == 0) {
				timestamp = tilNextMillis(lastTimestamp);
			}
		} else {
			sequence = 0L;
		}

		lastTimestamp = timestamp;
		
		// ID偏移组合生成最终的ID，并返回ID
		long id = ((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift) | (workerId << workerIdShift) | sequence; 
		return StringUtils.isNotEmpty(prefix) ? prefix + String.valueOf(id) : String.valueOf(id);
	}
	
	public synchronized long nextId() {
		long timestamp = timeGen();
		if (timestamp < lastTimestamp) {
			logger.error(String.format("clock is moving backwards. Rejecting requests until %d.", lastTimestamp));
			throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
		}

		if (lastTimestamp == timestamp) {
			// 当前毫秒内，则+1 
			sequence = (sequence + 1) & sequenceMask;
			if (sequence == 0) {
				timestamp = tilNextMillis(lastTimestamp);
			}
		} else {
			sequence = 0L;
		}

		lastTimestamp = timestamp;
		
		// ID偏移组合生成最终的ID，并返回ID
		return ((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift) | (workerId << workerIdShift) | sequence; 
	}
	

	protected long tilNextMillis(long lastTimestamp) {
		long timestamp = timeGen();
		while (timestamp <= lastTimestamp) {
			timestamp = timeGen();
		}
		return timestamp;
	}

	protected long timeGen() {
		return System.currentTimeMillis();
	}
}
