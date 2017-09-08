<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
    <title>尚自习  - 注册 | www.itzixi.com 程序员的进阶平台</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="leechenxiang" name="author" />
    
<!--     <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" /> -->
<!-- 	<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" /> -->
    <link href="<%=request.getContextPath() %>/static/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath() %>/static/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath() %>/static/global/plugins/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/static/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
    <!-- END GLOBAL MANDATORY STYLES -->
    <!-- BEGIN PAGE LEVEL PLUGINS -->
    <link href="<%=request.getContextPath() %>/static/global/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath() %>/static/global/plugins/select2/css/select2-bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath() %>/static/global/plugins/bootstrap-sweetalert/sweetalert.css" rel="stylesheet" type="text/css" />
    
	<link href="<%=request.getContextPath() %>/static/global/plugins/icheck/skins/all.css" rel="stylesheet" type="text/css" />
	
	<link href="<%=request.getContextPath() %>/static/global/plugins/bootstrap-modal/css/bootstrap-modal-bs3patch.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/static/global/plugins/bootstrap-modal/css/bootstrap-modal.css" rel="stylesheet" type="text/css" />
    <!-- END PAGE LEVEL PLUGINS -->
    <!-- BEGIN THEME GLOBAL STYLES -->
    <link href="<%=request.getContextPath() %>/static/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
	<link href="<%=request.getContextPath() %>/static/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
    <!-- END THEME GLOBAL STYLES -->
    <!-- BEGIN PAGE LEVEL STYLES -->
    <link href="<%=request.getContextPath() %>/static/pages/css/login-5.css" rel="stylesheet" type="text/css" />
    <!-- END PAGE LEVEL STYLES -->
	<link rel="shortcut icon" href="<%=request.getContextPath()%>/portal/image/itzixi_favicon.ico" type="image/x-icon">

	<style type="text/css">
		.help-block {
			display: block;
		  	margin-top: 5px;
		  	margin-bottom: 10px;
		  	color: red; 
		}
	</style>

	<script src="<%=request.getContextPath() %>/static/baiduTongji.js" type="text/javascript"></script>
	
</head>
<body class="login">
	<!-- BEGIN : LOGIN PAGE 5-1 -->
        <div class="user-login-5">
            <div class="row bs-reset">
                <div class="col-md-6 bs-reset mt-login-5-bsfix">
                    <div class="login-bg" style="">
                        <a href="<%=request.getContextPath()%>/">
                        	<img class="login-logo" src="<%=request.getContextPath()%>/portal/image/itzixi-logo.png" /> 
                        </a>
                    </div>
                </div>
                <div class="col-md-6 login-container bs-reset mt-login-5-bsfix">
                    <div class="login-content" id="regist-content">
                        <h1 class="font-green-jungle">欢迎注册尚自习</h1>
                        <p> ` `心态有多开放, 视野就有多开阔 · ❀不忘初心, 持之以恒 ❀❀ Stay hungry, Stay foolish.. </p>
                        
                        <form id="registForm" action="<%=request.getContextPath() %>/user/valEmailRegister.shtml" class="" method="post">

<!--                             <div class="form-group"> -->
<!-- 								<div class="input-icon"> -->
<!--                               		<i class="icon-user"></i> -->
<!--                                   	<input class="form-control placeholder-no-fix form-group" type="text" autocomplete="off" placeholder="Username" name="username" /> -->
<!--                                 </div>  -->
<!--                             </div> -->

							<div class="form-group">
                                	<div class="input-icon">
                                		<i class="icon-screen-smartphone"></i>
                                    	<input class="form-control placeholder-no-fix form-group" type="text" autocomplete="off" placeholder="手机号" name="mobile" id="mobile"/>
                                    </div> 
                            </div>

                            <div class="form-group">
                               	<div class="input-icon">
                               		<i class="icon-lock"></i>
                                   	<input id="password" name="password" class="form-control placeholder-no-fix form-group" type="password" autocomplete="off" placeholder="密码" />
                                </div> 
                            </div>
                            
<!--                             <div class="form-group"> -->
<!--                                 	<div class="input-icon"> -->
<!--                                 		<i class="icon-lock"></i> -->
<!--                                     	<input class="form-control placeholder-no-fix form-group" type="password" autocomplete="off" placeholder="Confirm Password" name="confirmPassword" /> -->
<!--                                     </div> -->
<!--                             </div> -->
                            
                            
                            
                            <div class="form-group">
                                		
                               		<div class="row">
                               			
											<div class="col-md-9">
												<div class="input-icon">
													<i class="icon-envelope"></i>
	                                    			<input class="form-control placeholder-no-fix form-group" type="text" autocomplete="off" placeholder="验证码" name="authCode"/>
												</div>
											</div>
									        <div class="col-md-3">
									        	<button id="btnGetAuthCode" type="button" class="btn green-meadow pull-right" disabled="disabled">获取手机动态验证码</button>
									        	<input type="hidden" id="totalSecond">
									        </div>
                                   	</div> 
                            </div>
                            
                            <div class="form-group">
								
								<label style="color: gray;">
									<input type="checkbox" class="icheck" id="agreement" checked="checked"> 我同意
								</label>
                            	<a  data-toggle="modal" href="#agree-content"> 《尚自习用户协议》 </a>
                            </div>
                            
<!--                             <div class="form-group"> -->
<!--                                 	<div class="input-icon"> -->
<!--                                 		<i class="fa fa-envelope "></i> -->
<!--                                     	<input class="form-control placeholder-no-fix form-group" type="text" autocomplete="off" placeholder="Email" id ="email" name="email" /> -->
<!--                                     </div>  -->
<!--                             </div> -->
                            
                            <div class="form-actions">
                                <a id="go-back-btn" class="btn blue-steel btn-outline" href="<%=request.getContextPath() %>/login.shtml">返回登录</a>
                                <button id="go-regist-btn" type="submit" class="btn green pull-right">立即注册</button>
                            </div>
                            
                        </form>
                        
                        <!-- 发送邮件后所显示的内容 start -->
                        <div id="afterSendEmail" style="display: none;">
                            <h4 class="font-green">注册验证链接地址已经发送至您的邮箱了，点击链接后即可注册成功！</h4>
                            <p> 系统已经向您的邮箱 <b id="yourEmail" class="font-yellow-gold"></b> 发送了一封验证链接，请前往您的邮箱完成激活验证噢~ </p>
                            <div class="form-actions">
                                <button type="button" id="goEmail" class="btn blue-steel">前往邮箱</button>
                            </div>
                        </div>
                        <!-- 发送邮件后所显示的内容 end -->
                        
                    </div>
                    <div class="login-footer">
                        <div class="row bs-reset">
                            <div class="col-xs-12 bs-reset">
                                <div class="login-copyright text-right">
                                    <p> &copy; 2017 尚自习 - 无锡福瑞博课网络科技有限公司</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <input type="hidden" id="hdnContextPath" name="hdnContextPath" value="<%=request.getContextPath() %>"/>
        
        <div id="agree-content" class="modal fade" tabindex="-1" data-width="760">
		     <div class="modal-header">
		         <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		         <h4 class="modal-title" style="font-weight: bold;">请认真仔细阅读本平台用户注册协议(www.itzixi.com)</h4>
		     </div>
		     <div class="modal-body">
		         <div class="row">
		             <div class="col-md-12">
		                 <div class="pay-protocol-content">
<!-- 				            <p>尚自习IT学习平台主要依靠网络高新技术制作，通过本平台向您在线提供在线学习与移动学习服务。请您在注册和使用本学习平台前仔细阅读本协议。若您不同意本协议的任何条款，请勿注册账号或使用本平台。</p> -->
<!-- 				            <h4 style="font-weight: bold;">一.注册协议条款的确认和接受</h4> -->
<!-- 				            <p>1、本协议双方为无锡福瑞博课软件开发有限公司旗下的尚自习平台（以下简称“本网站”或“本平台”）和尚自习平台注册用户。本协议阐述的条款和条件适用于尚自习平台（所涉域名为：www.itzixi.com）的全部学习服务，包括但不限于各种课程视频、学习内容、源代码、资料及相应服务。</p> -->
<!-- 				            <p>2、尚自习平台同意按照本协议的规定及其不定时发布的操作规则提供基于互联网和移动网的相关服务(以下称“网络服务”)。为获得网络服务，申请人应当认真阅读、充分理解本《协议》中各条款, 包括免除或者限制本网站责任的免责条款及对用户的权利限制条款。认真阅读并选择接受或不接受本《协议》(未成年人应在法定监护人陪同下阅读)。同意接受本协议的全部条款的，申请人应当按照页面上的提示完成全部的注册程序，并在注册程序过程中勾选“同意”选择框，否则视为不接受本《协议》全部条款，申请人应当终止并退出申请。</p> -->
<!-- 				            <p>3、注册用户在使用尚自习平台中的有关服务时，应承诺接受并遵守各项相关规则的规定。尚自习平台有权根据实际运营需要而不定时修改本协议或补充协议，如本协议有任何变更，将通过网站消息或其他方式通知用户。如注册用户不同意相关变更，则应立即终止账号使用，否则即视同用户同意并完全接受修订后的协议版本。经修订的协议一经公布于尚自习平台网站链接及页面，立即自动生效，亦成为本协议的一部分。注册用户登录且继续使用服务将被视为已接受修订后的协议。除书面另行声明外，任何扩大的服务范围及新增提供的内容均受本协议约束。</p> -->
<!-- 				            <h4 style="font-weight: bold;">二. 注册用户的权利和义务</h4> -->
<!-- 				            <p>1、用户在注册时应按照注册提示提供准确的用户名、密码及真实的联系邮箱、手机号码、真实姓名等所要求的个人资料，并及时更新注册（报名）资料，符合及时、详尽、准确的要求，用户输入的所有个人信息将被视作用户的准确身份信息。</p> -->
<!-- 				            <p>2、如果注册用户所提供的资料包含有不正确的、不良的、犯法的信息，本网站保留结束注册用户使用网络服务资格的权利。</p> -->
<!-- 				            <p>3、在支付课程或会员费用并经尚自习平台确认后，注册用户有权通过本人在尚自习平台的注册的账号享受相应服务。具体服务内容的时间、进度及期限以尚自习平台的具体课程及产品说明、公告及内容为准。</p> -->
<!-- 				            <p>4、尚自习平台的注册账号只为注册用户本人所专有并仅限由其本人自己使用，若经平台发现用户账号被其他人所使用或者传阅，本平台有权对相应的用户进行封号。</p> -->
<!-- 				            <p>5、未经尚自习平台许可，不得以任何形式向第三方转让、授权、出售尚自习平台课程、服务或授权第三方使用注册账号，不得以任何形式通过本站内容进行盈利活动，不得在商业环境下展映、传播本网站教学内容。</p> -->
<!-- 				            <p>6、注册用户仅对其在尚自习平台上享有的服务及内容有使用权，并不对该内容拥有相关知识产权。未经尚自习平台或其他有权第三方的许可，用户不得对包括视频、学习软件、学习资料、音频内容等在内的任何内容进行翻录、复制、发行、破解、信息网络传播或其他违反知识产权相关法律、法规的行为，否则所导致的一切民事、行政或刑事责任，由用户自行承担。</p> -->
<!-- 				            <p>7、对于用户在尚自习平台中所下载任何标有尚自习平台所有的资料，注册用户只得根据具体的使用协议进行使用，并不拥有该产品及产品中任何内容的一切知识产权。除非经相应的产品使用协议许可，注册用户不得自行或授权他人对软件或其中的任何一部分进行复制、反编译、倒序制造、反汇编、试图推导源代码、破译、修改或创作衍生作品，因此而造成尚自习平台或任何第三方的损失，由用户承担全部责任。尚自习平台对上述侵权或违约行为保留追索的权利。</p> -->
<!-- 				            <p>8、对于注册用户在尚自习平台提交的问题与笔记，注册用户同意尚自习平台对此内容享有复制、发行及独家的出版权。</p> -->
<!-- 				            <p>9、注册用户应对其账号的全部使用行为承担责任，应严格遵守本协议、相关法律法规、账号及课程使用规定。未经尚自习平台许可，禁止用户向任何第三方提供尚自习平台中的任何内容或资料。</p> -->
<!-- 				            <p>10、注册用户应自行配备上网的所需设备，包括个人电脑、调制解调器或其他必备上网装置；用户应自行负担因使用这种接入方式而产生的上网电话费、上网信息费等费用。</p> -->
<!-- 				            <p>11、尚自习平台的部分服务永久性；部分服务含有期限性，用户应在截止日期前享受其购买的服务。因到期服务终止所导致的任何后果，尚自习平台不承担任何责任。</p> -->
<!-- 				            <p>12、注册用户在尚自习平台进行充值（包括但不限于通过网上支付、邮局汇款、银行电汇、货到付款、上门购买并现金支付、自经销商处购买听课卡等各种购买方式），一经购买都不允许任何形式的退换和退费。</p> -->
<!-- 				            <p>13、用户在账号使用过程中不得制作、复制、发布、传播含有下列内容的信息： &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br><span style="line-height: 23.4px;">&nbsp; &nbsp; (1) 反对宪法所确定的基本原则的；<br></span><span class="indent" style="line-height: 23.4px;"><span style="line-height: 23.4px;">&nbsp; &nbsp;&nbsp;</span>(2) 危害国家安全，泄露国家秘密，颠覆国家政权，破坏国家统一的；<br></span><span class="indent" style="line-height: 23.4px;"><span style="line-height: 23.4px;">&nbsp; &nbsp;&nbsp;</span>(3) 损害国家荣誉和利益的；<br></span><span style="line-height: 23.4px;">&nbsp; &nbsp;&nbsp;</span><span style="line-height: 23.4px;">(4) 煽动民族仇恨、民族歧视，破坏民族团结的；<br></span><span style="line-height: 23.4px;">&nbsp; &nbsp;&nbsp;</span><span style="line-height: 23.4px;">(5) 破坏国家宗教政策，宣扬邪教和封建迷信的；<br></span><span style="line-height: 23.4px;">&nbsp; &nbsp;&nbsp;</span><span style="line-height: 23.4px;">(6) 散布谣言，扰乱社会秩序，破坏社会稳定的；<br></span><span class="indent" style="line-height: 23.4px;"><span style="line-height: 23.4px;">&nbsp; &nbsp;&nbsp;</span>(7) 散布淫秽、色情、赌博、暴力、凶杀、恐怖或者教唆犯罪的；<br></span><span class="indent" style="line-height: 23.4px;"><span style="line-height: 23.4px;">&nbsp; &nbsp;&nbsp;</span>(8) 侮辱或者诽谤他人，侵害他人合法权益的；<br></span><span style="line-height: 23.4px;">&nbsp; &nbsp;&nbsp;</span><span style="line-height: 23.4px;">(9) 干扰或者侵犯尚自习平台的正常运行和秩序，影响其他用户正常使用的；<br></span>&nbsp;&nbsp;&nbsp;&nbsp;<span style="line-height: 23.4px;">(10) 含有法律、行政法规禁止的其他信息内容的。</span></p><p></p> -->
<!-- 				            <p>14、注册用户将自行承担注册账号使用过程中可能发生的风险和损失。</p> -->
<!-- 				            <p>15、用户对本协议或将来的修改版本有任何异议的，或对产品服务存有异议或不满的，可以通过客服向尚自习平台有关部门进行反映沟通，不得通过煽动、诋毁及通过散布其他不良信息方式进行。</p> -->
<!-- 				            <h4 style="font-weight: bold;">三. 尚自习平台的权利和义务</h4> -->
<!-- 				            <p>1、尚自习平台有义务通过现有技术维护尚自习平台的正常运行，并努力提升和改进服务使用户的学习活动得以顺利进行；由于不可抗力所导致服务的中止或终止，尚自习平台不对因此造成注册用户的任何损失承担责任。</p> -->
<!-- 				            <p>2、用户在注册及使用尚自习平台过程中遇到的相关问题，尚自习平台将力争及时作出反馈。</p> -->
<!-- 				            <p>3、如因系统维护或升级而需暂停服务时，尚自习平台应提前告知用户。</p> -->
<!-- 				            <p>4、尚自习平台不保证其服务一定能够满足用户的全部要求，也不担保其服务不会因各种客观原因中断。</p> -->
<!-- 				            <h4 style="font-weight: bold;">四. 免责条款</h4> -->
<!-- 				            <p>1、当用户所享有的服务中显示其他第三方网站或内容时，由于尚自习平台无法控制及审核该网站或内容，因此并不对该网站或内容真实性、有效性、合法性等效力承担责任。对于用户任何因使用或信赖该网站或内容所导致的任何直接或间接损失，尚自习平台均不承担任何责任。</p> -->
<!-- 				            <p>2、由于用户将个人注册账号信息告知他人或与他人共享注册帐号的，由此导致的任何风险或损失，尚自习平台不对此负任何责任。</p> -->
<!-- 				            <p>3、任何由于黑客攻击、计算机病毒侵入或发作、政府管制、硬件故障、不可抗力等非尚自习平台故意或严重过失而造成的用户个人资料泄露、丢失、被盗用、被篡改或服务暂定或终止的，对注册用户所造成的风险或损失，尚自习平台均得免责。</p> -->
<!-- 				            <p>4、若因线路及非尚自习平台控制范围外的或其它不可抗力而导致暂停服务暂定或终止，所造成的一切风险与损失，尚自习平台不负任何责任。</p> -->
<!-- 				            <p>5、尚自习平台有权根据用户的实际需求进行服务调整的权利，并有权根据实际情况调整本网站内容的售价， 由此造成的一切不便与损失，尚自习平台均得免责。</p> -->
<!-- 				            <p>6、有权利删减自己的课程。</p> -->
<!-- 				            <h4 style="font-weight: bold;">五. 隐私条款</h4> -->
<!-- 				            <p>尚自习平台将严格履行用户个人隐私保密义务，承诺不公开、编辑或透露用户个人信息，但以下情况除外： -->
<!-- 				                <br><span class="indent"><span style="line-height: 23.4px;">&nbsp; &nbsp;&nbsp;</span>1、经用户授权透露这些信息；</span> -->
<!-- 				                <br><span class="indent"><span style="line-height: 23.4px;">&nbsp; &nbsp;&nbsp;</span>2、应政府部门、法律及法规要求提供、披露相关用户个人资料；</span> -->
<!-- 				                <br><span class="indent"><span style="line-height: 23.4px;">&nbsp; &nbsp;&nbsp;</span>3、在特定情况下，为竭力维护用户个人、其他社会个体和公共安全需要。</span> -->
<!-- 				            </p> -->
<!-- 				            <h4 style="font-weight: bold;">六. 法律</h4> -->
<!-- 				            <p>本协议根据现行中华人民共和国法律法规制定并解释。如发生协议条款与中华人民共和国法律法规相抵触时，则抵触内容将按法律规定重新解释，但不影响其它条款的效力。</p> -->
<!-- 				            <h4 style="font-weight: bold;">七. 解释权</h4> -->
<!-- 				            <p>上述条款的解释权在法律允许的范围内归尚自习平台所有。</p> -->
				        </div>
		             </div>
		         </div>
		     </div>
		     <div class="modal-footer">
		         <button type="button" data-dismiss="modal" class="btn btn-outline dark">关  闭</button>
		     </div>
		 </div>
        
        <!-- END : LOGIN PAGE 5-1 -->
        <!--[if lt IE 9]>
<script src="../assets/global/plugins/respond.min.js?v=3.1415926"></script>
<script src="../assets/global/plugins/excanvas.min.js?v=3.1415926"></script> 
<script src="../assets/global/plugins/ie8.fix.min.js?v=3.1415926"></script> 
<![endif]-->
        
        <!-- 公用尾部JS start -->
	    <jsp:include page="common/commonFooterJS.jsp"></jsp:include>
	    <!-- 公用尾部JS end -->
    
        <!-- BEGIN PAGE LEVEL SCRIPTS -->
        <script src="<%=request.getContextPath() %>/static/pages/js/regist.js?v=1.01" type="text/javascript"></script>
        <!-- END PAGE LEVEL SCRIPTS -->
        
        <!-- 页面要用到的私有JS start -->
<%-- 	    <script src="<%=request.getContextPath() %>/static/pages/js/login.js?v=3.1415926" type="text/javascript"></script> --%>
	    <!-- 页面要用到的私有JS end -->
        
</body>
</html>
