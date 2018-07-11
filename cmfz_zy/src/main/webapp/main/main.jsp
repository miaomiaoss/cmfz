<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/IconExtension.css">
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>--%>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css"/>

    <script type="text/javascript" src="${pageContext.request.contextPath}/script/common.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
<script type="text/javascript">
	<!--菜单处理-->
    $(function(){

        $.post("${pageContext.request.contextPath}/queryMenu",
            function (res) {
                $.each(res,function (index1,parent) {
                    //console.log(parent.title);
                    var c = "";
                   // console.log(parent.childrenMen);
                    $.each(parent.childrenMen, function (index2,child) {
                       //console.log(child.title);
                        //console.log(child.iconcls);
                        c += "<p><a class='easyui-linkbutton' data-options=\"iconCls:'"+child.iconcls+"'\" onClick=\"checkTabs('"+child.title+"','"+child.href+"','"+child.iconcls +"')\" >" + child.title + "</a></p>"
                    });

                    $('#aa').accordion('add', {
                        title: parent.title,
                        content: c,
                        selected: false
                    });
                });

            }
        );

        $("#exit").linkbutton({
            iconCls:'icon-01',
            onClick:function () {
                $.get(
                    "${pageContext.request.contextPath}/exit",
                    function () {
                        location.href = "${pageContext.request.contextPath}/login.jsp";
                    }
                );
            }
        })
    });

	function checkTabs(title,href,iconcls) {
	   //console.log(href);
       var flag =  $("#tt").tabs("exists",title);
        if (!flag) {
            $("#tt").tabs('add',{
                title:title,
                //content:'Tab Body',
                closable:true,
                href:"${pageContext.request.contextPath}/"+href
            });
        }else{
            $("#tt").tabs("select",title);
        }
    }

</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.Admin.name} &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a id="exit">退出系统</a></div>
    </div>
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">

    	<div id="aa" class="easyui-accordion" data-options="fit:true">
    		
		</div>
    </div>
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>   
</body> 
</html>
