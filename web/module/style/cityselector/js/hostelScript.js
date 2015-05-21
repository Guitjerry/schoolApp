/**
 * Created by Administrator on 2015/5/19.
 */
var hostelSelector = {};
hostelSelector.pc=new Array();
hostelSelector.zs=new Array();



hostelSelector.pc[0] = new Array("东校区", "东校区8栋|东校区9栋|东校区10栋");
hostelSelector.pc[1] = new Array("西校区", "西校区12栋|西校区13栋|西校区15栋");
hostelSelector.pc[2] = new Array("南校区", "南校区20栋|南校区21栋|南校区22栋");
hostelSelector.pc[3] = new Array("北校区", "北校区33栋|北校区34栋|北校区35栋");


hostelSelector.zs[0] = new Array("中山东校区", "东校区18栋|东校区19栋|东校区10栋");
hostelSelector.zs[1] = new Array("中山西校区", "西校区12栋|西校区13栋|西校区15栋");
hostelSelector.zs[2] = new Array("中山南校区", "南校区20栋|南校区21栋|南校区22栋");
hostelSelector.zs[3] = new Array("中山北校区", "北校区33栋|北校区34栋|北校区35栋");

hostelSelector.pc.hotCity = ["西校区12栋"];
hostelSelector.zs.hotCity = ["北校区33栋"];
hostelSelector.Init = function (input) {
    $("#" + input).click(function () {
        var locationParam=$("#school").val();
        if(locationParam==""){
            rdcp.toastrErrorMessage("设置楼号前必须选择学校","系统提示")
        }
        hostelSelector.hotCityhtmls = "";
        hostelSelector.provHtmls = "";
        $("#hostel").val("");
        if(locationParam=="北京大学"){
            itemParmnLength=hostelSelector.pc.length;
            hotItemParmnLength=hostelSelector.pc.hotCity.length;
        }else if(locationParam=="中山大学"){
            itemParmnLength=hostelSelector.zs.length;
            hotItemParmnLength=hostelSelector.zs.hotCity.length;
        }

        for (var j = 0; j < itemParmnLength; j++) {
            var itemParmn="";
           if(locationParam=="北京大学"){
               itemParmn=hostelSelector.pc[j][0];
           }else if(locationParam=="中山大学"){
               itemParmn=hostelSelector.zs[j][0];
           }
            hostelSelector.provHtmls += "<li data-xuhao='" + j + "'><span class='provinceName'>" + itemParmn + "</span></li>";
        }


        for (var i = 0; i <hotItemParmnLength; i++) {
            var hotItemParmn="";
            if(locationParam=="北京大学"){
                hotItemParmn=hostelSelector.pc.hotCity[i]
            }else if(locationParam=="中山大学"){
                hotItemParmn=hostelSelector.zs.hotCity[i]
            }
            hostelSelector.hotCityhtmls += "<li class='js_cityName'>" + hotItemParmn + "</li>";

        }

        hostelSelector.template = '<div class="city-box" id="js_cityBox"><div class="prov-city" id="js_provCity"><p>热门校区<span style="padding-left: 300px;cursor: pointer" onclick="hideDiv()">x</span></p><ul>' + hostelSelector.hotCityhtmls + '</ul></div><div class="provence"><div>选择楼区</div><div><ul id="js_provList">' + hostelSelector.provHtmls + '</ul></div></div></div>';




        $("#js_cityBox").remove();
        $("body").append(hostelSelector.template);

        var _top = $(this).offset().top + 40,
            _left = $(this).offset().left,
            _width = $(window).width();
        if (_width - _left < 450) {
            $("#js_cityBox").css({"top": _top + "px", "right": "0px"}).addClass("rightSelector");
        }
        else {
            $("#js_cityBox").css({"top": _top + "px", "left": _left + "px"});
        }

        var label = "false";
        $("#js_provList").on("click", ".provinceName", function () {
            function createUl(_this) {
                _this.css({
                    "background": "#fff",
                    "border-color": "#d8d8d8",
                    "border-bottom-color": "#fff",
                    "position": "absolute",
                    "top": "0",
                    "left": "0",
                    "z-index": "999999"
                });
                var xuhao = _this.parent("li").attr("data-xuhao"),
                    cityArr = hostelSelector.pc[xuhao][1].split("|"),
                    cityHtmls = "<ul id='js_provCitys'>";
                for (var i = 0; i < cityArr.length; i++) {
                    cityHtmls += "<li class='js_cityName'>" + cityArr[i] + "</li>";
                }
                cityHtmls += "</ul>";
                $("#js_provCitys").remove();
                _this.parent("li").append(cityHtmls);
            }

            if (label == "false") {
                label = "true";
                $(this).attr("now-item", "true");
                createUl($(this));
            }
            else {
                if ($(this).attr("now-item") == "" || $(this).attr("now-item") == "false" || $(this).attr("now-item") == undefined) {
                    $(this).parents("#js_provList").find("span").attr("now-item", "false");
                    $(this).attr("now-item", "true");
                    $("#js_provList span").css({
                        "background": "",
                        "border-color": "",
                        "border-bottom-color": "",
                        "position": "",
                        "top": "",
                        "left": "",
                        "z-index": ""
                    });
                    $("#js_provCitys").remove();
                    createUl($(this));
                }
                else {
                    label = "false";
                    $(this).css({
                        "background": "",
                        "border-color": "",
                        "border-bottom-color": "",
                        "position": "",
                        "top": "",
                        "left": "",
                        "z-index": ""
                    });
                    $("#js_provCitys").remove();
                }
            }

        });

        var _input = input;
        $("#js_cityBox").on("click", ".js_cityName", function (e) {
            e.stopPropagation();
            $("#" + _input).val($(this).html());
            $("#js_cityBox").remove();
        });
    });
}

function hideDiv(){
    $(".city-box").hide();
}