<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 9]>
<script src="<%=request.getContextPath() %>/static/global/plugins/respond.min.js"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/excanvas.min.js"></script> 
<script src="<%=request.getContextPath() %>/static/global/plugins/ie8.fix.min.js"></script> 
<![endif]-->

<input type="hidden" id="hdnContextPath" name="hdnContextPath" value="<%=request.getContextPath() %>"/>

<!-- BEGIN CORE PLUGINS -->
<script src="<%=request.getContextPath() %>/static/global/plugins/jquery.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/bootstrap/js/bootstrap.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/js.cookie.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/jquery.blockui.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js?v=3.1415926" type="text/javascript"></script>
<%-- <script src="<%=request.getContextPath() %>/static/global/plugins/bootstrap-switch-master/dist/js/bootstrap-switch.min.js?v=3.1415926" type="text/javascript"></script> --%>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="<%=request.getContextPath() %>/static/global/plugins/moment.min.js?v=3.1415926" type="text/javascript"></script>

<script src="<%=request.getContextPath() %>/static/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js?v=3.1415926" type="text/javascript"></script>

<script src="<%=request.getContextPath() %>/static/global/plugins/morris/morris.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/morris/raphael-min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/counterup/jquery.waypoints.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/counterup/jquery.counterup.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/fullcalendar/fullcalendar.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/horizontal-timeline/horizontal-timeline.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/flot/jquery.flot.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/flot/jquery.flot.resize.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/flot/jquery.flot.categories.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/jquery-easypiechart/jquery.easypiechart.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/jquery.sparkline.min.js?v=3.1415926" type="text/javascript"></script>

<script src="<%=request.getContextPath() %>/static/global/plugins/bootstrap-select/js/bootstrap-select.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/jquery-multi-select/js/jquery.multi-select.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/select2/js/select2.full.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/jquery-validation/js/jquery.validate.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/jquery-validation/js/additional-methods.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/backstretch/jquery.backstretch.min.js?v=3.1415926" type="text/javascript"></script>

<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN THEME GLOBAL SCRIPTS -->
<script src="<%=request.getContextPath() %>/static/global/scripts/app.js?v=3.1415926" type="text/javascript"></script>
<!-- END THEME GLOBAL SCRIPTS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="<%=request.getContextPath() %>/static/global/plugins/jquery.form.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/pages/scripts/form-validation.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/bootstrap-sweetalert/sweetalert.js?v=3.1415926" type="text/javascript"></script>

<script src="<%=request.getContextPath() %>/static/global/plugins/Guriddo_jqGrid_JS_5.2.0/js/i18n/grid.locale-cn.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/Guriddo_jqGrid_JS_5.2.0/js/jquery.jqGrid.min.js?v=3.1415926" type="text/javascript"></script>

<%-- <script src="<%=request.getContextPath() %>/static/global/plugins/jquery-ui-1.12.1.custom/jquery-ui.min.js?v=3.1415926" type="text/javascript"></script> --%>
<%-- <script src="<%=request.getContextPath() %>/static/global/plugins/jquery.jqGrid-4.4.3/js/jquery.jqGrid.min.js?v=3.1415926" type="text/javascript"></script> --%>
<!-- END PAGE LEVEL SCRIPTS -->

<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="<%=request.getContextPath() %>/static/pages/scripts/dashboard.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/pages/scripts/ui-sweetalert.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/pages/scripts/ui-blockui.min.js?v=3.1415926" type="text/javascript"></script>

<script src="<%=request.getContextPath() %>/static/global/plugins/icheck/icheck.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/pages/scripts/form-icheck.js?v=3.1415926" type="text/javascript"></script>

<script src="<%=request.getContextPath() %>/static/global/plugins/bootstrap-modal/js/bootstrap-modalmanager.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/bootstrap-modal/js/bootstrap-modal.js?v=3.1415926" type="text/javascript"></script>

<script src="<%=request.getContextPath() %>/static/global/plugins/jquery-inputmask/jquery.inputmask.bundle.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/jquery.input-ip-address-control-1.0.min.js?v=3.1415926" type="text/javascript"></script>

<%-- <script src="<%=request.getContextPath() %>/static/citys/js/distpicker.data.js?v=3.1415926"></script> --%>
<%-- <script src="<%=request.getContextPath() %>/static/citys/js/distpicker.js?v=3.1415926"></script> --%>
<script src="<%=request.getContextPath() %>/static/global/plugins/file-uploader/js/vendor/jquery.ui.widget.js?v=3.1415926"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/file-uploader/js/jquery.fileupload.js?v=3.1415926"></script>

<script src="<%=request.getContextPath() %>/static/global/plugins/echarts.min.js?v=3.1415926"></script>

<!-- include summernote css/js-->
<script src="<%=request.getContextPath() %>/static/global/plugins/summernote/dist/summernote.js?v=3.1415926"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/summernote/lang/summernote-zh-CN.js?v=3.1415926"></script>

<script src="<%=request.getContextPath() %>/static/global/plugins/counterup/jquery.waypoints.min.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/global/plugins/counterup/jquery.counterup.min.js?v=3.1415926" type="text/javascript"></script>


<!-- END PAGE LEVEL SCRIPTS -->

<!-- BEGIN 自己写的页面JS -->
<%-- <script src="<%=request.getContextPath() %>/static/pages/js/menu.js?v=3.1415926" type="text/javascript"></script> --%>
<script src="<%=request.getContextPath() %>/static/pages/js/ajaxCallbackError.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/pages/js/commonJSFunction.js?v=3.1415926" type="text/javascript"></script>

<!-- END 自己写的页面JS -->

<!-- BEGIN THEME LAYOUT SCRIPTS -->
<script src="<%=request.getContextPath() %>/static/layouts/layout/scripts/layout.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/layouts/layout/scripts/demo.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/layouts/global/scripts/quick-sidebar.js?v=3.1415926" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/layouts/global/scripts/quick-nav.js?v=3.1415926" type="text/javascript"></script>
<!-- END THEME LAYOUT SCRIPTS -->

      
      
      
      
