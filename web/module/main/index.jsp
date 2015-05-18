<%@ page import="com.sushe.entity.User" %>
<%--
  Created by IntelliJ IDEA.
  User: jiangbin
  Date: 15/5/3
  Time: 下午5:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="utf-8"/>
    <title>主页</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <meta name="MobileOptimized" content="320">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../module/main/index.css"/>
</head>
<body style="background: #deedf7 ">
<jsp:include page="/module/style/common/header.jsp"></jsp:include>

<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="profile-sidebar col-md-3">
                <div class="portlet light profile-sidebar-portlet">
                    <div class="profile-userpic">
                        <img src="${sessionScope.user.sticker}" class="img-responsive">
                    </div>
                    <div class="profile-usertitle">

                        <div class="profile-username">${sessionScope.user.name} </div>
                        <div class="profile-userhostel">${sessionScope.user.account}</div>

                    </div>
                    <div class="profile-userbuttons">
                        <%--<form method="post" enctype="multipart/form-data" action="/form.do" style="position: relative; overflow: hidden;">--%>
                            <a href="#" class="site-btn site-btn-green" style="cursor: default;" onclick="upload_pro()">上传头像 </a>
                            <%--&lt;%&ndash;<button type="button" onclick="upload_pro()">上传头像</button>&ndash;%&gt;--%>
                            <%--<button type="submit" class="btn">提交</button>--%>
                            <%--&lt;%&ndash;<input type="submit" class="site-btn site-btn-green" value="提交" style="display: block;"/>&ndash;%&gt;--%>
                            <%--<input type="hidden" name="name"/>--%>
                            <%--<input type="file" name="icon" class="upload-btn-placeholder">--%>
                        <%--</form>--%>
                        <%--<button type="button" class="btn btn-circle green-haze btn-sm">上传头像</button>--%>
                        <%--<button type="button" class="btn btn-circle btn-danger btn-sm">账户设置</button>--%>
                    </div>
                </div>

                <div class="profile-challage">
                    <div role="tabpanel" class="profile-challage-info">
                        <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation" class="active">
                                <a href="#home" role="tab" data-toggle="tab">挑战信息</a>
                            </li>
                            <li role="presentation">
                                <a href="#more" role="tab" data-toggle="tab">发起的挑战</a>
                            </li>
                        </ul>

                        <div class="tab-content">
                            <div class="tab-pane profile-challage-tab" id="home">
                                <ul class="list-group profile-challage-tab-list">
                                    <li class="list-group-item">
                                        <a class="profile-challage-tab-content">302宿舍</a>
                                        <span class="glyphicon glyphicon-trash">删除</span>
                                        <span class="glyphicon glyphicon-ok">接受</span>
                                        <span class="glyphicon glyphicon-remove">拒绝</span>
                                    </li>
                                    <li class="list-group-item">
                                        <a class="profile-challage-tab-content">302宿舍</a>
                                        <span class="glyphicon glyphicon-trash">删除</span>
                                        <span class="glyphicon glyphicon-ok">接受</span>
                                        <span class="glyphicon glyphicon-remove">拒绝</span>
                                    </li>
                                    <li class="list-group-item">
                                        <a class="profile-challage-tab-content">302宿舍</a>
                                        <span class="glyphicon glyphicon-trash">删除</span>
                                        <span class="glyphicon glyphicon-ok">接受</span>
                                        <span class="glyphicon glyphicon-remove">拒绝</span>
                                    </li>
                                    <li class="list-group-item">
                                        <a class="profile-challage-tab-content">302宿舍</a>
                                        <span class="glyphicon glyphicon-trash">删除</span>
                                        <span class="glyphicon glyphicon-ok">接受</span>
                                        <span class="glyphicon glyphicon-remove">拒绝</span>
                                    </li>
                                </ul>
                                <!--<div class="panel panel-default">-->

                                <!--<div class="panel-body">-->
                                <!---->
                                <!--</div>-->
                                <!---->
                                <!--</div>-->
                            </div>
                            <div class="tab-pane profile-challage-tab" id="more">
                                <ul class="list-group profile-challage-tab-list">
                                    <li class="list-group-item">
                                        <a class="profile-challage-tab-content">302宿舍</a>
                                        <span class="glyphicon glyphicon-trash">删除</span>
                                        <span class="glyphicon glyphicon-share-alt">分享</span>
                                    </li>
                                    <li class="list-group-item">
                                        <a class="profile-challage-tab-content">302宿舍</a>
                                        <span class="glyphicon glyphicon-trash">删除</span>
                                        <span class="glyphicon glyphicon-share-alt">分享</span>

                                    </li>
                                    <li class="list-group-item">
                                        <a class="profile-challage-tab-content">302宿舍</a>
                                        <span class="glyphicon glyphicon-trash">删除</span>
                                        <span class="glyphicon glyphicon-share-alt">分享</span>

                                    </li>
                                    <li class="list-group-item">
                                        <a class="profile-challage-tab-content">302宿舍</a>
                                        <span class="glyphicon glyphicon-trash">删除</span>
                                        <span class="glyphicon glyphicon-share-alt">分享</span>

                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>


            </div>


            <div class="school-feed-detail col-md-6">
                <div class="school-detail">
                    <div class="school-feed-text">
                        人人都是摄影师，快点拿起手机随手记录生活中的美好吧！我正在使用
                        <a href="#">#随手拍</a>
                        主题模板，你也来一键换装吧！
                    </div>
                    <div class="school-media-wrap clearfix">
                        <div class="media-box">
                            <ul class="school_media_a school-media_a_m1 clearfix">
                                <li class="school-bigcursor">
                                    <img src="../../module/main/img/profile_user.jpg" title="放大">
                                </li>
                                <li class="school-bigcursor">
                                    <img src="../../module/main/img/profile_user.jpg" title="放大">
                                </li>
                                <li class="school-bigcursor">
                                    <img src="../../module/main/img/profile_user.jpg" title="放大">
                                </li>
                            </ul>
                        </div>


                    </div>

                    <div class="school-from-txt">
                        <a href="school-from-time">5分钟前</a>
                        来自
                        <a class="school-txt" href="#">微博 weibo.com</a>
                    </div>
                    <div class="school-feed-handle">
                        <div class="school-handle">
                            <ul class="school-row-line">
                                <li>
                                    <a class="school-txt">
                                <span class="pos">
                                <span class="school-line1">
                                <i class="school-txt" title="此条信息已经被阅读5次">阅读5次</i>
                                </span>
                                </span>
                                    </a>
                                </li>
                                <li>
                                    <a class="school-txt">
                                    <span class="pos">
                                    <span class="school-line1">
                                    转发
                                    </span>
                                    </span>
                                    </a>
                                </li>
                                <li>
                                    <a class="school-txt">
                                    <span class="pos">
                                    <span class="school-line1">
                                    评论
                                    </span>
                                    </span>
                                    </a>
                                </li>
                                <li>
                                    <a class="school-txt">
                                    <span class="pos">
                                    <span class="school-line1">
                                    <span class="glyphicon glyphicon-thumbs-up"></span>
                                    </span>
                                    </span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>

                </div>
                <div style="height: 10px">

                </div>


                <div class="school-detail">
                    <div class="school-feed-text">
                        人人都是摄影师，快点拿起手机随手记录生活中的美好吧！我正在使用
                        <a href="#">#随手拍</a>
                        主题模板，你也来一键换装吧！
                    </div>
                    <div class="school-media-wrap clearfix">
                        <div class="media-box">
                            <ul class="school_media_a school-media_a_m1 clearfix">
                                <li class="school-bigcursor">
                                    <img src="../../module/main/img/profile_user.jpg" title="放大">
                                </li>
                                <li class="school-bigcursor">
                                    <img src="../../module/main/img/profile_user.jpg" title="放大">
                                </li>
                                <li class="school-bigcursor">
                                    <img src="../../module/main/img/profile_user.jpg" title="放大">
                                </li>
                            </ul>
                        </div>


                    </div>

                    <div class="school-from-txt">
                        <a href="school-from-time">5分钟前</a>
                        来自
                        <a class="school-txt" href="#">微博 weibo.com</a>
                    </div>
                    <div class="school-feed-handle">
                        <div class="school-handle">
                            <ul class="school-row-line">
                                <li>
                                    <a class="school-txt">
                                <span class="pos">
                                <span class="school-line1">
                                <i class="school-txt" title="此条信息已经被阅读5次">阅读5次</i>
                                </span>
                                </span>
                                    </a>
                                </li>
                                <li>
                                    <a class="school-txt">
                                    <span class="pos">
                                    <span class="school-line1">
                                    转发
                                    </span>
                                    </span>
                                    </a>
                                </li>
                                <li>
                                    <a class="school-txt">
                                    <span class="pos">
                                    <span class="school-line1">
                                    评论
                                    </span>
                                    </span>
                                    </a>
                                </li>
                                <li>
                                    <a class="school-txt">
                                    <span class="pos">
                                    <span class="school-line1">
                                    <span class="glyphicon glyphicon-thumbs-up"></span>
                                    </span>
                                    </span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>

                </div>
                <div style="height: 10px">

                </div>

                <div class="school-detail">
                    <div class="school-feed-text">
                        人人都是摄影师，快点拿起手机随手记录生活中的美好吧！我正在使用
                        <a href="#">#随手拍</a>
                        主题模板，你也来一键换装吧！
                    </div>
                    <div class="school-media-wrap clearfix">
                        <div class="media-box">
                            <ul class="school_media_a school-media_a_m1 clearfix">
                                <li class="school-bigcursor">
                                    <img src="../../module/main/img/profile_user.jpg" title="放大">
                                </li>
                                <li class="school-bigcursor">
                                    <img src="../../module/main/img/profile_user.jpg" title="放大">
                                </li>
                                <li class="school-bigcursor">
                                    <img src="../../module/main/img/profile_user.jpg" title="放大">
                                </li>
                            </ul>
                        </div>


                    </div>

                    <div class="school-from-txt">
                        <a href="school-from-time">5分钟前</a>
                        来自
                        <a class="school-txt" href="#">微博 weibo.com</a>
                    </div>
                    <div class="school-feed-handle">
                        <div class="school-handle">
                            <ul class="school-row-line">
                                <li>
                                    <a class="school-txt">
                                <span class="pos">
                                <span class="school-line1">
                                <i class="school-txt" title="此条信息已经被阅读5次">阅读5次</i>
                                </span>
                                </span>
                                    </a>
                                </li>
                                <li>
                                    <a class="school-txt">
                                    <span class="pos">
                                    <span class="school-line1">
                                    转发
                                    </span>
                                    </span>
                                    </a>
                                </li>
                                <li>
                                    <a class="school-txt">
                                    <span class="pos">
                                    <span class="school-line1">
                                    评论
                                    </span>
                                    </span>
                                    </a>
                                </li>
                                <li>
                                    <a class="school-txt">
                                    <span class="pos">
                                    <span class="school-line1">
                                    <span class="glyphicon glyphicon-thumbs-up"></span>
                                    </span>
                                    </span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>

                </div>
                <div style="height: 10px">

                </div>
                <div class="school-detail">
                    <div class="school-feed-text">
                        人人都是摄影师，快点拿起手机随手记录生活中的美好吧！我正在使用
                        <a href="#">#随手拍</a>
                        主题模板，你也来一键换装吧！
                    </div>
                    <div class="school-media-wrap clearfix">
                        <div class="media-box">
                            <ul class="school_media_a school-media_a_m1 clearfix">
                                <li class="school-bigcursor">
                                    <img src="../../module/main/img/profile_user.jpg" title="放大">
                                </li>
                                <li class="school-bigcursor">
                                    <img src="../../module/main/img/profile_user.jpg" title="放大">
                                </li>
                                <li class="school-bigcursor">
                                    <img src="../../module/main/img/profile_user.jpg" title="放大">
                                </li>
                            </ul>
                        </div>


                    </div>

                    <div class="school-from-txt">
                        <a href="school-from-time">5分钟前</a>
                        来自
                        <a class="school-txt" href="#">微博 weibo.com</a>
                    </div>
                    <div class="school-feed-handle">
                        <div class="school-handle">
                            <ul class="school-row-line">
                                <li>
                                    <a class="school-txt">
                                <span class="pos">
                                <span class="school-line1">
                                <i class="school-txt" title="此条信息已经被阅读5次">阅读5次</i>
                                </span>
                                </span>
                                    </a>
                                </li>
                                <li>
                                    <a class="school-txt">
                                    <span class="pos">
                                    <span class="school-line1">
                                    转发
                                    </span>
                                    </span>
                                    </a>
                                </li>
                                <li>
                                    <a class="school-txt">
                                    <span class="pos">
                                    <span class="school-line1">
                                    评论
                                    </span>
                                    </span>
                                    </a>
                                </li>
                                <li>
                                    <a class="school-txt">
                                    <span class="pos">
                                    <span class="school-line1">
                                    <span class="glyphicon glyphicon-thumbs-up"></span>
                                    </span>
                                    </span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>

                </div>



            </div>

            <div class="school-right-detail col-md-3">
                <div class="school-right-content">
                    <div class="school-right-module">
                        <div class="school-right-title">
                            <h4 class="obj_name">
                                <a class="school_a_txt">可能感兴趣的人</a>
                            </h4>

                            <div class="opt_box">
                                <a href="#">
                                    <span class="glyphicon glyphicon-refresh">换一换</span>
                                </a>
                            </div>
                        </div>
                        <div class="school-right-inner">
                            <div class="school-right-inner-wrap clearfix">
                                <ul class="person_list">
                                    <li>
                                        <div class="pic">
                                            <a href="#">
                                                <img src="http://tp2.sinaimg.cn/5187664653/50/40058043651/1"
                                                     class="person-face">
                                            </a>
                                        </div>
                                        <div class="con">
                                            <p class="name">
                                                <a href="#">
                                                    邓超
                                                </a>
                                            </p>
                                            <span>
                                                <a href="#" class="school-title-btn">
                                                    <em class="person_add">+</em>
                                                    关注
                                                </a>
                                            </span>

                                            <div class="change">
                                                <a href="#">
                                                    x
                                                </a>
                                            </div>

                                        </div>

                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="school-right-inner">
                            <div class="school-right-inner-wrap clearfix">
                                <ul class="person_list">
                                    <li>
                                        <div class="pic">
                                            <a href="#">
                                                <img src="http://tp2.sinaimg.cn/5187664653/50/40058043651/1"
                                                     class="person-face">
                                            </a>
                                        </div>
                                        <div class="con">
                                            <p class="name">
                                                <a href="#">
                                                    邓超
                                                </a>
                                            </p>
                                            <span>
                                                <a href="#" class="school-title-btn">
                                                    <em class="person_add">+</em>
                                                    关注
                                                </a>
                                            </span>

                                            <div class="change">
                                                <a href="#">
                                                    x
                                                </a>
                                            </div>

                                        </div>

                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="school-right-inner">
                            <div class="school-right-inner-wrap clearfix">
                                <ul class="person_list">
                                    <li>
                                        <div class="pic">
                                            <a href="#">
                                                <img src="http://tp2.sinaimg.cn/5187664653/50/40058043651/1"
                                                     class="person-face">
                                            </a>
                                        </div>
                                        <div class="con">
                                            <p class="name">
                                                <a href="#">
                                                    邓超
                                                </a>
                                            </p>
                                            <span>
                                                <a href="#" class="school-title-btn">
                                                    <em class="person_add">+</em>
                                                    关注
                                                </a>
                                            </span>

                                            <div class="change">
                                                <a href="#">
                                                    x
                                                </a>
                                            </div>

                                        </div>

                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="school-right-inner">
                            <div class="school-right-inner-wrap clearfix">
                                <ul class="person_list">
                                    <li>
                                        <div class="pic">
                                            <a href="#">
                                                <img src="http://tp2.sinaimg.cn/5187664653/50/40058043651/1"
                                                     class="person-face">
                                            </a>
                                        </div>
                                        <div class="con">
                                            <p class="name">
                                                <a href="#">
                                                    邓超
                                                </a>
                                            </p>
                                          <span>
                                              <a href="#" class="school-title-btn">
                                                  <em class="person_add">+</em>
                                                  关注
                                              </a>
                                          </span>

                                            <div class="change">
                                                <a href="#">
                                                    x
                                                </a>
                                            </div>

                                        </div>

                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="school-right-inner">
                            <div class="school-right-inner-wrap clearfix">
                                <ul class="person_list">
                                    <li>
                                        <div class="pic">
                                            <a href="#">
                                                <img src="http://tp2.sinaimg.cn/5187664653/50/40058043651/1"
                                                     class="person-face">
                                            </a>
                                        </div>
                                        <div class="con">
                                            <p class="name">
                                                <a href="#">
                                                    邓超
                                                </a>
                                            </p>
                                            <span>
                                                <a href="#" class="school-title-btn">
                                                    <em class="person_add">+</em>
                                                    关注
                                                </a>
                                            </span>

                                            <div class="change">
                                                <a href="#">
                                                    x
                                                </a>
                                            </div>

                                        </div>

                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </div>
</div>
<div id="user_img" style="width: 740px"></div>

</body>
</html>
<script src="../../module/style/rdcp/rdcp.js"></script>
<%--<script src="../../module/style/jquery/jquery.min.js"></script>--%>
<%--<script src="../../module/style/bootstrap/bootstrap.min.js"></script>--%>
<script src="../../module/style/common/slidePanel.js"></script>
<script>
    rdcp.ready(function(){

    })
    //上传头像
    function upload_pro(){
        slidePanel("user_img","../../module/user/user_head_config.html",{success:function(){

        }})
    }
</script>
