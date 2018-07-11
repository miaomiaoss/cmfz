<%@page contentType="text/html;charset=utf-8" %>
<script type="text/javascript">
    $(function () {
        $("#picname").textbox({});
        $("#picpath").textbox({});
        $("#description").textbox({});
        $("#status").textbox({});
        $("#url").textbox({});

        $("#f2").form("load","${pageContext.request.contextPath}/getOneBanner?id="+bannerId);

        $("#changeSub").linkbutton({
            iconCls:"icon-add",
            onClick:function () {
                $("#f2").form("submit",{
                    url:"${pageContext.request.contextPath}/changeBanner",
                    onSubmit:function () {

                    },
                    success:function () {
                        $.messager.show({
                            title:"advice",
                            msg:"change successful!"
                        });

                        $("#changeBanner").dialog("close");
                        $("#banner").edatagrid("load");
                    }
                })
            }
        });
    });

</script>

<form id="f2" method="post">
    PicName:<input id="picname" name="picname"></br>
    Picpath:<input id="picpath" name="picpath" ></br>
    Description:<input id="description" name="description"></br>
    Status:<input id="status" name="status"></br>
    Url:<input id="url" name="url"></br>

    <a id="changeSub">change</a>
</form>