<%@page contentType="text/html; charset=utf-8" %>
<script type="text/javascript">
    $(function(){
        $('#queryUserTable').datagrid({
            url:'${pageContext.request.contextPath}/queryAllUser',
            pagination:true,
            fitColumns:true,
            pageList:[3,5,7,9],
            toolbar:"#userTools",
            columns:[[
                {field:'name',title:'Name',width:100,align:'center'},
                {field:'userName',title:'UserName',width:100,align:'center'},
                {field:'password',title:'Password',width:100,align:'center'},
                {field:'salt',title:'Salt',width:100,align:'center'},
                {field:'sex',title:'sex',width:100,align:'center'}
            ]]
        });


        $("#querySomeUserDialog").dialog({
            title: "Query User Details",
            width: 300,
            height: 400,
            closed: true,
            cache: false,
            href: "${pageContext.request.contextPath}/user/checkUser.jsp",
            modal: true,
            buttons:"#querySomeUserTools"
        });

        $("#querySomeBtn").linkbutton({
            iconCls:"icon-search",
            plain:true,
            onClick:function () {
                $("#querySomeUserDialog").dialog("open");
            }
        });
        $("#queryAllBtn").linkbutton({
            iconCls:"icon-search",
            plain:true,
            onClick:function () {

            }
        });
        $("#querySomeUserSubBtn").linkbutton({
            iconCls:"icon-search",
            plain:true,
            onClick:function () {
                var text = $("#getUserDetails").combotree("getText");
                var values = $("#getUserDetails").combotree("getValues");

                var a = "";
                $.each(values,function (index, value) {
                    if(index === values.length-1){
                        a+=value;
                    }else{
                        a+=value+",";
                    }
                });
                // console.log(text);
                // console.log(a);
                $("#getUserForm").form("submit",{
                    url:"${pageContext.request.contextPath}/exportUser",
                    queryParams:{
                        "text":text,
                        "values":values
                    }
                });
                $("#querySomeUserDialog").dialog("close");
            }
        });


    });



</script>

<div id="userTools">
    <a id="queryAllBtn">导出所有</a>
    <a id="querySomeBtn">自定义导出</a>
</div>


<table id="queryUserTable"></table>
<div id="querySomeUserDialog"></div>
<div id="querySomeUserTools">
    <a id="querySomeUserSubBtn">导出</a>
</div>
<div id="queryUserDialog"></div>