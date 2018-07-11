<%@page contentType="text/html; charset=utf-8" %>

<script type="text/javascript">
    $('#getUserDetails').combotree({
        required: true,
        checkbox:true,
        onlyLeafCheck:true,
        multiple:true,
        data:[{
            "id":"custom",
            "text":"请选择",
            "state":"closed",
            "children":[{
                "id":"name",
                "text":"名字"
            },{
                "id":"sex",
                "text":"性别"
            },{
                "id":"createtime",
                "text":"创建时间"
            },{
                "id":"status",
                "text":"状态"
            }]
        }]
    });

    $("#getUserBtn").linkbutton({
        iconCls:"icon-add",
        onClick:function () {

        }
    });
</script>
<form id="getUserForm" method="post">
    <input id="getUserDetails">
</form>
