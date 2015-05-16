rdcp.ready(function(){
    if($(".user-login-reg .ui-tab-control ul li").length>0){
        $("#main").show();
    }
    login_click($(".user-login-reg .ui-tab-control ul li").eq(0))
    initValidate();
});

//会员注册Tab
function regiest_click(obj){
    var obj=$(obj);
    obj.parent("ul").children("li").eq(0).removeClass("active").addClass("active");
    obj.parent("ul").children("li").eq(1).removeClass("active");
    $(".ui-tab-container .ui-tab-toggle").eq(0).removeClass("hide").addClass("hide");
    $(".ui-tab-container .ui-tab-toggle").eq(1).removeClass("hide");
}
function login_click(obj){
    var obj=$(obj);
    obj.parent("ul").children("li").eq(1).removeClass("active").addClass("active");
    obj.parent("ul").children("li").eq(0).removeClass("active");
    $(".ui-tab-container .ui-tab-toggle").eq(1).removeClass("hide").addClass("hide");
    $(".ui-tab-container .ui-tab-toggle").eq(0).removeClass("hide");
}
//注册会员
function regiest_user(){
    if($("#regiest_form input[name='password']").val()!=$("#regiest_form input[name='re_password']").val()){
        $("#msg").val("");
    }else{
        $("#msg").val("default");
    }
    if(validateForm("regiest_form")){
        var param=rdcp.serializeObject('#regiest_form');


        $.ajax({
            url:"user/regiestUser.do?account="+$("#regiest_form input[name='account']").val(),
            success:function(data){
                var obj= rdcp.str2json(data);
                if(obj.status=='success'){
                    $.ajax({
                        url:"user/insertSimple.do",
                        data:param,
                        type:"post",
                        success:function(data){
                            var obj= rdcp.str2json(data);
                            if(obj.status=='success'){
                                rdcp.toastrInfoMessage(obj.msg,"系统提示");
                            }else{
                                rdcp.toastrErrorMessage(obj.msg,"系统提示");
                            }
                        }
                    })
                }else{
                    rdcp.toastrErrorMessage(obj.msg,"系统提示");
                }
            }

        })


    }
}
//登录用户
function login_on(){
    if(validateForm("login_form")){
        var login_param=rdcp.serializeObject('#login_form');
        $.ajax({
            url:"user/login.do",
            data:login_param,
            success:function(data){
                var obj= rdcp.str2json(data);
                if(obj.status=='success'){
                    rdcp.toastrInfoMessage(obj.msg,"系统提示");
                    window.location.href="module/main/index.jsp"

                }else{
                    rdcp.toastrErrorMessage(obj.msg,"系统提示");
                }
            }

        })
    }

}