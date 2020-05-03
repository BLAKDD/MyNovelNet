<%--
  Created by IntelliJ IDEA.
  User: BLAKD
  Date: 2020/4/18
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title id="pageTitle">Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/icon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/icon-Autocomplate.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/icon-Dropdown.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/icon-Popup.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/demo.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bookinfo.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/myCss.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/md5.js"></script>
</head>

<body>
<dialog class="loginDialog" id="loginDialog">
    <div class="loginDiv">
        <ul>
            <h2 class="loginTitle">用户登录</h2>
            <li><label>账号</label><input type="text" id="userId"/></li>
            <li><label>密码</label><input type="password" id="password"/></li>
            <li>
                <a id="confirmLoginBtn" class="loginBtn" href="javascript:" onclick="cofirmLogin()">登录</a>
                <a id="loginDialogCloseBtn" class="loginBtn" href="javascript:"
                   onclick="closeLoginDialog()">取消登录</a>
            </li>
        </ul>
    </div>
</dialog>
<div class="outer-wrap">
    <div class="navigater">
        <ul class="head-menu">
            <li class="site">
                <a href="/index" class="title">小说阅读网</a>
            </li>
            <li><a href="">全部作品</a></li>
            <li><a href="">排行</a></li>
        </ul>
        <div class="search-box">
            <input type="text" class="search" id="search" placeholder="这是一个提示">
            <label for="search">
                <em class="iconfont">&#xe60d;</em>
            </label>
            <span class="line"></span>
            <ul class="head-menu">
                <li id="alreadyLogin" class="more" style="display: none">
                    <a id="user-name" href="/self" target="_blank"><i
                            class="arrow"></i></a>
                    <div class="drop-down">
                        <a href="javascript:void(0);">个人主页</a>
                        <a href="javascript:void(0);">充值</a>
                        <a id="exit-btn" class="login" href="javascript:" onclick="exitLogin()">退出</a>
                    </div>
                </li>
            </ul>

            <div id="needLogin" class="btn-g">
                <a id="loginBtn" href="javascript:" onclick="loginBtnClick()">登录</a>
                <a href="/register" target="_blank">注册</a>
            </div>

            <span class="line"></span>
            <div class="shelf">
                <a href="javascript:;" class="">
                    <em class="iconfont">&#xe60c;</em>
                    我的书架</a>
            </div>
        </div>
    </div>
    <div class="path">
        <div class="path-box" id="topCategoryList">
            <a href="">首页</a>
            <em class="iconfont">&#xe621;</em>
        </div>
    </div>
    <div class="bookinfo">
        <div class="book-head">
            <div class="img">
                <img id="bookCover" src="https://bookcover.yuewen.com/qdbimg/349573/1016402042/180" alt="">
            </div>
            <div class="concrete-det">
                <div class="det-title">
                    <span id="novelNameId">诸天单机大玩家</span>
                    <span id="writerNameId">若清峰&nbsp;著</span>
                </div>
                <div class="book-tags">
                    <span class="tags f" id="stateId">连载</span>
                    <span class="tags f" id="ifSignId">签约</span>
                    <span class="tags f" id="ifVipId">免费</span>
                    <a href="javascript:void(0);" id="pCategoryId" class="tags t">科幻</a>
                    <a href="javascript:void(0);" id="categoryId" class="tags t">时空穿梭</a>
                </div>
                <div id="introductionId">星海漫游，时空穿梭，机械科技，目标是未知的星辰大海！</div>
                <div class="book-params">
                        <span class="num" id="wordCountId">22.68
                            <span class="num-unit">万字</span>
                        </span>
                    <span class="line"></span>
                    <span class="num" id="allRecCountId">1.66
                            <span class="num-unit">万总推荐</span>
                        </span>
                    <span class="line"></span>
                    <span class="num" id="weekRecCountId">2245
                            <span class="num-unit">周推荐</span>
                        </span>
                </div>
                <div class="book-menu-btn">
                    <a id="readProgress" href="javascript:void(0);" class="book-btn book-f">免费试读</a>
                    <a id="ifBookShelf" href="javascript:void(0);" class="book-btn book-t">加入书架</a>
                </div>
            </div>
            <div class="comment-num">
                <span style="font: 400 32px/38px FZZCYSK">0</span>
                <i style="font: 700 32px/1 Arial;">.</i>
                <span style="font: 400 24px/38px FZZCYSK">0</span>
                <p style="font-size: 12px; color: #999;">人评价</p>
            </div>
        </div>
        <div class="info-catalogue">
            <div class="info-cata-menu">
                <span id="w_info">作品信息</span>
                <span id="w_menu">目录 (<i id="chapterSum" style="font-style: normal;">100</i>章) </span>
            </div>
            <div class="info" id="workinfo">
                <div class="info-left">
                    <p class="left-text" id="novelDetailIntroId">
                        小说暂无简介<br>
                    </p>
                    <ul class="author-area">
                        <li>
                            <p class="li-menu">最新更新</p>
                            <div>
                                <a id="newestChapter" class="link-blue" href="javascript:void(0);">尚未更新</a>
                                <span class="uptime" id="lastupdataTime">-</span>
                            </div>
                        </li>
                    </ul>
                    <ul class="fans-comments">
                        <div id="comment">
                            <div class="fans">评论</div>
                            <div class="release-comment">
                                <div class="img-container">
                                    <img src="https://facepic.qidian.com/qd_face/349573/a400391497/0" alt="">
                                </div>
                                <div class="input-area">
                                    <div class="input-com">
                                        <textarea name="input" id="input" cols="30" rows="10" maxlength="150"
                                                  placeholder="发表你的观点吧"></textarea>
                                    </div>
                                    <div class="release-box"><span class="num-limit" id="limit">还剩150字</span> <a
                                            href="javascript:void(0);">发布</a></div>
                                </div>
                            </div>
                        </div>
                        <div class="fans">全部评论</div>
                        <li>
                            <div class="img-container">
                                <img src="https://facepic.qidian.com/qd_face/349573/a400391497/0" alt="">
                            </div>
                            <div class="comments-text">
                                <a href="javascript:void(0);" class="user-name">胡为东&nbsp;:</a>
                                <p class="comments-content">WoW!You can really dance!</p>
                                <p class="publish-time">2020-4-16</p>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="info-right">
                    <div class="author-img">
                        <img src="https://facepic.qidian.com/qd_face/349573/a400391497/0" alt="">
                        <span class="author-level" id="writerLevelId">LV.2</span>
                        <p class="author-name" id="rightWriterNameId">若清峰</p>
                    </div>
                    <div class="work-state">
                        <div>
                            <span class="book"></span>
                            <p>作品数</p>
                            <em id="novelCountId">0</em>
                        </div>
                        <div>
                            <span class="word"></span>
                            <p>累计字数</p>
                            <em id="writerWordCountId">0.00万</em>
                        </div>
                        <div>
                            <span class="coffee"></span>
                            <p>创作天数</p>
                            <em id="updateCountId">0</em>
                        </div>
                    </div>
                </div>
            </div>
            <div class="catalogue" id="catalogue"></div>
        </div>
    </div>
    <div class="footer">
        <p>上海网警提示：网络刷单是违法 切莫轻信有返利，网上交友套路多 卖惨要钱需当心，电子红包莫轻点 个人信息勿填写，仿冒客服来行骗 官方核实最重要，招工诈骗有套路 预交费用需谨慎，低价充值莫轻信
            莫因游戏陷套路，连接WIFI要规范 确认安全再连接，抢购车票有章法 确认订单再付款，白条赊购慎使用 提升额度莫轻信，网购预付有风险 正规渠道很重要 如网民接到962110电话，请立即接听。</p>
        <div class="help">
            <a href="javascript:;">帮助中心</a>
            <a href="javascript:;">举报中心</a>
        </div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/static/js/bookinfo.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/login.js"></script>
</html>
