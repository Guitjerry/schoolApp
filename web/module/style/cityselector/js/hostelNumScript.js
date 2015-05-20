var hostelNumSelector = {};
hostelNumSelector.hotCityhtmls = "";

hostelNumSelector.Init = function (input) {
    for (var i = 0; i <5; i++) {
        hostelNumSelector.hotCityhtmls += "<li class='js_cityName'>" +"屌丝宿舍" + "</li>";
    }
    hostelNumSelector.template = '<div class="city-box" id="js_cityBox"><div class="prov-city" id="js_provCity"><p>校区宿舍<span style="padding-left: 300px;cursor: pointer" onclick="hideDiv()">x</span></p><ul>' + hostelNumSelector.hotCityhtmls + '</ul></div></div>';
    $("#" + input).click(function () {
        var locationParam=$("#hostel_num").val();
        if(locationParam==""){
            rdcp.toastrErrorMessage("设置宿舍前必须选择校区楼盘","系统提示");
            return;
        }
        //请求得到学校Id
        $.ajax({
            url:"../../school/selectSchoolByName.do",
            data:{"name":$("#school").val()},
            success:function(data){
                var obj=rdcp.str2json(data);
                if(obj.status=="success"){
                    //根据学校,楼盘找到相关宿舍
                }
            }
        })
        $("#js_cityBox").remove();
        $("body").append(hostelNumSelector.template);

        var _top = $(this).offset().top + 40,
            _left = $(this).offset().left,
            _width = $(window).width();
        if (_width - _left < 450) {
            $("#js_cityBox").css({ "top": _top + "px", "right": "0px" }).addClass("rightSelector");
        }
        else {
            $("#js_cityBox").css({ "top": _top + "px", "left": _left + "px" });
        }
    });
}
function hideDiv(){
    $(".city-box").hide();
}