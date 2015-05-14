rdcp.toastrDefaults={
    "closeButton": false,
    "debug": false,
    "newestOnTop": false,
    "progressBar": false,
    "positionClass": "toast-top-center",
    "preventDuplicates": false,
    "onclick": null,
    "showDuration": "300",
    "hideDuration": "1000",
    "timeOut": "5000",
    "extendedTimeOut": "1000",
    "showEasing": "swing",
    "hideEasing": "linear",
    "showMethod": "fadeIn",
    "hideMethod": "fadeOut"
}
/**
 *
 * @param type 类型
 * @param msg 信息
 * @param title 标题
 * @param option 具体参数
 */
rdcp.toastrSuccessMessage=function(msg,title,option){
    var optionsParam= $.extend({},rdcp.toastrDefaults,option);
    toastr.options=optionsParam;
    toastr['success'](msg,title)
}
rdcp.toastrInfoMessage=function(msg,title,option){
    var optionsParam= $.extend({},rdcp.toastrDefaults,option);
    toastr.options=optionsParam;
    toastr['info'](msg,title)
}
rdcp.toastrWarnMessage=function(msg,title,option){
    var optionsParam= $.extend({},rdcp.toastrDefaults,option);
    toastr.options=optionsParam;
    toastr['warning'](msg,title)
}
rdcp.toastrErrorMessage=function(msg,title,option){
    var optionsParam= $.extend({},rdcp.toastrDefaults,option);
    toastr.options=optionsParam;
    toastr['error'](msg,title)
}