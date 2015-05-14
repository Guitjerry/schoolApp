var defaultMessage={
    nullMessage:"该项必填",
    invalidMessage:"输入的格式不正确"
};
var validate={};
validate.message=function(message){
    validate.initErrorContainer(id);
    if (jQuery.type(message) === "array")
        $.each(message,function(i,obj){
            _tip(obj);
        });
    else _tip(message);
    $('#validate_error_message').show('slow',function(){
        setTimeout(function(){$('#validate_error_message').hide('slow').empty();},3000);
    });
}
validate.initErrorContainer=function(id){
    if($('#validate_error_message').length==0){
        $("#"+id+"-vaild-msg").append("<div id='validate_error_message' class='wrongTipsBox'style='z-index: 9999;display: none;'></div>");
        $('#validate_error_message').bind('click',function(){
            $('#validate_error_message').hide('3000').empty();
        });
    }else{
        $('#validate_error_message').empty();
    }
}

function validateForm(id){

    var inputList=$("#"+id+" input,#"+id+" textarea");//获取表单下面需要输入的域
    var selectList=$("#"+id+" select");
    var position=$("#"+id).attr('tipposition');
    var count = 0 ;//统计验证失败次数
    var cache = {};//缓存已经处理的表单字段 针对checkbox radio
    validate.initErrorContainer(id);
    for(var i=0;i<inputList.length;i++){
        var _input = inputList[i];
        var span = $(inputList[i]);
        var message;     //错误信息
        var validateValue = {
            nullable: span.attr('nullable'),
            pattern: span.attr('pattern'),
            syspattern: span.attr('syspattern'),
            nullmessage: span.attr('nullmessage'),
            invalidmessage: span.attr('invalidmessage')
        };
        if (_input.type == "checkbox" || _input.type == "radio"){
            if(validateValue.nullable=="false" && cache[_input.name] != "true") {
                cache[_input.name] = "true";
                var isChecked = $("#"+id+" input[name='"+_input.name+"']:checked");
                var span = $("#"+id+" input[name='"+_input.name+"']");
                if (isChecked.length == 0) {
                    //错误提示
                    message=validateValue.invalidmessage==undefined?"至少选中一个":validateValue.nullmessage;
                   // _tooltip(position,message,$(span[span.length-1]));
                    _tip(message);
                    count++;
                    continue;
                }
            }
        }
        else{
            if(_input.value==""||_input.value==undefined){
                if(validateValue.nullable=='false'){
                    //设置不能为空提示信息 自定义 模板提示 系统默认
                    if(validateValue.nullmessage!=undefined){
                        message=validateValue.nullmessage;
                    }
                    else if($.trim(validateValue.syspattern) != ""&&validateValue.syspattern!=undefined&&
                        patternTmpl[validateValue.syspattern]['null_message']!=undefined){
                        message=patternTmpl[validateValue.syspattern]['null_message'];
                    }
                    else{
                        message=defaultMessage.nullMessage;
                    }
                    _tip(message);
                    span.css({'background':'#ffefd0'});
                    count++;
                    continue;
                }
            }
            else{
                var pattern;
                if($.trim(validateValue.pattern) != ""&&validateValue.pattern!=undefined){
                    pattern = validateValue.pattern;
                    message=validateValue.invalidmessage==undefined?defaultMessage.invalidMessage:validateValue.invalidmessage;
                }
                else if($.trim(validateValue.syspattern) != ""&&validateValue.syspattern!=undefined){
                    pattern=patternTmpl[validateValue.syspattern]['pattern'];
                    message=validateValue.invalidmessage==undefined?patternTmpl[validateValue.syspattern]['invalid_message']:validateValue.invalidmessage;
                }
                else{
                    continue;
                }
                if(!_validateRex(_input.value,pattern)){
                    _tip(message);
                    span.css({'background':'#ffefd0'});
                    count++;
                    continue;
                }
            }
        }
    }
    for(var i=0;i<selectList.length;i++){
        var validateValue = {
            syspattern: $(selectList[i]).attr('syspattern'),
            "nullable":$(selectList[i]).attr("nullable"),
            "pattern": $(selectList[i]).attr("pattern"),
            "nullmessage": $(selectList[i]).attr("nullmessage"),
            "invalidmessage": $(selectList[i]).attr("invalidmessage")
        };
        //目前只对必填进行处理
        if(validateValue.nullable=='false'){
            //设置不能为空提示信息 自定义 模板提示 系统默认
            if(validateValue.nullmessage!=undefined){
                message=validateValue.nullmessage;
            }
            else if($.trim(validateValue.syspattern) != ""&&validateValue.syspattern!=undefined&&
                patternTmpl[validateValue.syspattern]['null_message']!=undefined){
                message=patternTmpl[validateValue.syspattern]['null_message'];
            }
            else{
                message=defaultMessage.nullMessage;
            }
            _tip(message);
            span.css({'background':'#ffefd0'});
            count++;
            continue;
        }
    }
    if(count>0){
        $('#validate_error_message').show('slow',function(){
            setTimeout(function(){$('#validate_error_message').hide('slow').empty()},3000);

        });
        return false;
    }
    $('#validate_error_message').hide('3000').empty();
    return true;
};
var _tip=function(message){
    //$.jGrowl(message);
    $('#validate_error_message').append("<div class='wrongLine'><p>"+message+"</p></div>");
}
/**
 * 提供正则表达式验证
 * @param {Object} value 表单值
 * @param {Object} vMsg 验证规则
 */
var _validateRex = function (value,pattern) {
    if (typeof(pattern) != "undefined" &&$.trim(pattern) != "") {
        var rex = new RegExp(pattern);
        return rex.test(value);
    }
    return true;
};

/**
 * 对于提示初始化
 * 如需使用 请在所需的验证域添加 class=‘srValidate’（必需）和
 * tipposition=top right等 默认为right
 *
 */

function initValidate(id){
    var $v = $('.srValidate');
    for(var i=0;i<$v.length;i++){
        var _v=$($v[i]);
        if(_v.attr('nullable')!=undefined&&_v.attr('nullable')=="false"){
            if(_v.attr('nullmessage')==undefined){
                var message;
                if(_v.attr('syspattern')!=undefined){
                    message=patternTmpl[_v.attr('syspattern')]['null_message'];
                    if(message!=undefined&&message!=""){
                        _v.attr('nullmessage',message);
                    }
                    else{
                        _v.attr('nullmessage',defaultMessage.nullMessage);
                    }
                }
                else{
                    _v.attr('nullmessage',defaultMessage.nullMessage);
                }
            }
        }
        var _pattern="";
        if(_v.attr('pattern')!=undefined){

            if(_v.attr('invalidmessage')==undefined||_v.attr('invalidmessage')==""){
                _v.attr('invalidmessage',defaultMessage.invalidMessage);
            }
            _pattern=_v.attr('pattern');
        }
        if(_v.attr('syspattern')!=undefined){

            if(_v.attr('invalidmessage')==undefined||_v.attr('invalidmessage')==""){

                _v.attr('invalidmessage',patternTmpl[_v.attr('syspattern')]['invalid_message']);

            }
            if(_pattern==""){
                _pattern=patternTmpl[_v.attr('syspattern')]['pattern'];
            }
        }
        initTooltip(_v,message,_pattern);
        keyUpListen(_v,message,_pattern);

    }
};

function keyUpListen(obj,message,_pattern){
    var _v = $(obj);
    _v.bind('keyup',function(){
        if($(this).val()!=""){
            if(_pattern!=""&&!_validateRex($(this).val(),_pattern)){
                message=_v.attr('invalidmessage')!=undefined?_v.attr('invalidmessage'):defaultMessage.invalidMessage;
                $(this).tooltip('update',"<span style='color:RGB(244,126,18)'>"+message+"</span>" );
            }
            else{
                $(this).tooltip('update'," <a class='btn_ok' href='javascript:void(0)'></a>");
                $(this).css({'background':'#ffffff'});
            }
        }
        else{
            if(_v.attr('nullable')=="false"){
                message=_v.attr('nullmessage')!=undefined?_v.attr('nullmessage'):defaultMessage.nullMessage;
                $(this).tooltip('update', "<span style='color:RGB(244,126,18)'> * "+message+"</span>");
            }
            else{
                $(this).tooltip('update'," <a class='btn_ok' href='javascript:void(0)'></a>");
                $(this).css({'background':'#ffffff'});
            }
        }

    });
}
function  initTooltip(obj,message,_pattern){
    var _v=$(obj);
    _v.tooltip({
        content:_v.attr('invalidmessage')!=undefined?_v.attr('invalidmessage'):"<span style='color:RGB(244,126,18)'>*"+_v.attr('nullmessage')+"</span>",
        position:_v.attr('tipposition')!=undefined?_v.attr('tipposition'):"right",

        onShow:function(){
            if($(this).val()!=""){
                if(_pattern!=""&&!_validateRex($(this).val(),_pattern)){
                    message=_v.attr('invalidmessage')!=undefined?_v.attr('invalidmessage'):defaultMessage.invalidMessage;
                    $(this).tooltip('update',"<span style='color:RGB(244,126,18)'>"+message+"</span>" );
                }
                else{
                    $(this).tooltip('update'," <a class='btn_ok' href='javascript:void(0)'></a>");
                    $(this).css({'background':'#ffffff'});
                }
            }
            else{
                if(_v.attr('nullable')=="false"){
                    message=_v.attr('nullmessage')!=undefined?_v.attr('nullmessage'):defaultMessage.nullMessage;
                    $(this).tooltip('update', "<span style='color:RGB(244,126,18)'> * "+message+"</span>");
                }
                else{
                    $(this).tooltip('update'," <a class='btn_ok' href='javascript:void(0)'></a>");
                    $(this).css({'background':'#ffffff'});
                }
            }
        },
        onHide:function(){
            if($(this).val()!=""){
                if(_pattern!=""&&!_validateRex($(this).val(),_pattern)){
                    $(this).css({'background':'#ffefd0'});
                }
                else{
                    $(this).css({'background':'#ffffff'});
                }
            }
            else{
                if(_v.attr('nullable')=="false"){
                    $(this).css({'background':'#ffefd0'});
                }
                else{
                    $(this).css({'background':'#ffffff'});
                }
            }
        }
    });
}

