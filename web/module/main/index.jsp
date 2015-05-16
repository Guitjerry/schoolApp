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
<body>
<div class="header navbar  navbar-default navbar-fixed-top">
    <div class="header-inner">
        <ul class="nav navbar-nav  pull-right">
            <li class="dropdown" id="header-notification-bar"
                style="outline: 0px; box-shadow: rgba(102, 188, 230, 0) 0px 0px 13px; outline-offset: 20px;">
                <a data-toggle="dropdown" class="dropdown-toggle" data-hover="dropdown-toggle">
                    <button class="btn btn-primary">
                        <span class="glyphicon glyphicon-bell">消息</span>
                        <span class="badge">9</span>
                    </button>
                </a>
                <ul class="dropdown-menu extended notification">
                    <li>
                        <p>
                            14条消息
                        </p>
                    </li>
                    <li>
                        <div class="slimScrollDiv"
                             style="position: relative; overflow: hidden; width: auto; height: 250px;">
                            <ul class="dropdown-menu-list scroller"
                                style="height: 250px; overflow: hidden; width: auto;">
                                <li>
                                    <a href="#">
								<span class="label label-sm label-icon label-success">
									<i class="glyphicon glyphicon-edit"></i>
								</span>
                                        新用户注册
								<span class="time">
									1mius
								</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
								<span class="label label-sm label-icon label-danger">
									<i class="glyphicon glyphicon-edit"></i>
								</span>
                                        Server #12 overloaded.
								<span class="time">
									15 mins
								</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
								<span class="label label-sm label-icon label-warning">
									<i class="glyphicon glyphicon-edit"></i>
								</span>
                                        Server #2 not responding.
								<span class="time">
									22 mins
								</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
								<span class="label label-sm label-icon label-danger">
									<i class="glyphicon glyphicon-edit"></i>
								</span>
                                        Database overloaded 68%.
								<span class="time">
									2 hrs
								</span>
                                    </a>
                                </li>
                            </ul>
                            <div class="slimScrollBar"
                                 style="width: 7px; position: absolute; top: 0px; opacity: 0.4; display: none; border-radius: 7px; z-index: 99; right: 1px; height: 160.25641025641px; background: rgb(161, 178, 189);"></div>
                            <div class="slimScrollRail"
                                 style="width: 7px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; opacity: 0.2; z-index: 90; right: 1px; background: rgb(51, 51, 51);"></div>
                        </div>
                    </li>
                    <li class="external">
                        <a href="#">See all notifications <i class="m-icon-swapright"></i></a>
                    </li>
                </ul>

            </li>


            <li class="dropdown" id="header-chanllage-bar"
                style="outline: 0px; box-shadow: rgba(221, 81, 49, 0) 0px 0px 13px; outline-offset: 20px;">
                <a data-toggle="dropdown" class="dropdown-toggle" data-hover="dropdown-toggle">
                    <button class="btn btn-danger">
                        <span class="glyphicon glyphicon-globe">挑战</span>
                        <span class="badge">5</span>
                    </button>
                </a>
                <ul class="dropdown-menu extended inbox">
                    <li>
                        <p>
                            You have 12 new messages
                        </p>
                    </li>
                    <li>
                        <div class="slimScrollDiv"
                             style="position: relative; overflow: hidden; width: auto; height: 250px;">
                            <ul class="dropdown-menu-list scroller"
                                style="height: 250px; overflow: hidden; width: auto;">
                                <li>
                                    <a href="inbox.html?a=view">
								<span class="photo">
									<img src="../../module/main/img/profile_user.jpg" alt="">
								</span>
								<span class="subject">
									<span class="from">
										Lisa Wong
									</span>
									<span class="time">
										Just Now
									</span>
								</span>
								<span class="message">
									 Vivamus sed auctor nibh congue nibh. auctor nibh auctor nibh...
								</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="inbox.html?a=view">
								<span class="photo">
									<img src="../../module/main/img/profile_user.jpg" alt="">
								</span>
								<span class="subject">
									<span class="from">
										Richard Doe
									</span>
									<span class="time">
										16 mins
									</span>
								</span>
								<span class="message">
									 Vivamus sed congue nibh auctor nibh congue nibh. auctor nibh auctor nibh...
								</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="inbox.html?a=view">
								<span class="photo">
									<img src="../../module/main/img/profile_user.jpg" alt="">
								</span>
								<span class="subject">
									<span class="from">
										Bob Nilson
									</span>
									<span class="time">
										2 hrs
									</span>
								</span>
								<span class="message">
									 Vivamus sed nibh auctor nibh congue nibh. auctor nibh auctor nibh...
								</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="inbox.html?a=view">
								<span class="photo">
									<img src="../../module/main/img/profile_user.jpg" alt="">
								</span>
								<span class="subject">
									<span class="from">
										Lisa Wong
									</span>
									<span class="time">
										40 mins
									</span>
								</span>
								<span class="message">
									 Vivamus sed auctor 40% nibh congue nibh...
								</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="inbox.html?a=view">
								<span class="photo">
									<img src="../../module/main/img/profile_user.jpg" alt="">
								</span>
								<span class="subject">
									<span class="from">
										Richard Doe
									</span>
									<span class="time">
										46 mins
									</span>
								</span>
								<span class="message">
									 Vivamus sed congue nibh auctor nibh congue nibh. auctor nibh auctor nibh...
								</span>
                                    </a>
                                </li>
                            </ul>
                            <div class="slimScrollBar"
                                 style="width: 7px; position: absolute; top: 0px; opacity: 0.4; display: none; border-radius: 7px; z-index: 99; right: 1px; height: 140.134529147982px; background: rgb(161, 178, 189);"></div>
                            <div class="slimScrollRail"
                                 style="width: 7px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; opacity: 0.2; z-index: 90; right: 1px; background: rgb(51, 51, 51);"></div>
                        </div>
                    </li>
                    <li class="external">
                        <a href="inbox.html">See all messages <i class="m-icon-swapright"></i></a>
                    </li>
                </ul>

            </li>

            <li class="dropdown dropdown-user">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-close-others="true">
                    <img alt class="img-circle" src="../../module/main/img/profile_user.jpg" style="width:36px">
                    <span class="username username-hide-on-mobile">
                        Nick
                    </span>
                    <i class="glyphicon glyphicon-chevron-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-menu-default">
                    <li>
                        <a href="#">
                            <i class="glyphicon glyphicon-user"></i>
                            个人设置
                        </a>
                        <a href="#">
                            <i class="glyphicon glyphicon-wrench"></i>
                            密码设置
                        </a>
                        <a href="#">
                            <i class="glyphicon glyphicon-off"></i>
                            退出登陆
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>

<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="profile-sidebar col-md-3">
                <div class="portlet light profile-sidebar-portlet">
                    <div class="profile-userpic">
                        <img src="../../module/main/img/personal.png" class="img-responsive">
                    </div>
                    <div class="profile-usertitle">

                        <div class="profile-username">${sessionScope.user.name} </div>
                        <div class="profile-userhostel">${sessionScope.user.account}</div>

                    </div>
                    <div class="profile-userbuttons">
                        <button type="button" class="btn btn-circle green-haze btn-sm">上传头像</button>
                        <button type="button" class="btn btn-circle btn-danger btn-sm">账户设置</button>
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


</body>
</html>
<script src="../../module/style/jquery/jquery.min.js"></script>
<script src="../../module/style/bootstrap/bootstrap.min.js"></script>
