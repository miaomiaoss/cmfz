<%@page contentType="text/html;charset=utf-8" %>
<script type="text/javascript">

    var bannerId;
    $(function () {


        $('#banner').edatagrid({
            title: 'TurnPicture',
            remoteSort: false,
            singleSelect: true,
            nowrap: false,
            fitColumns: true,
            pagination: true,
            pageList: [2, 5, 10, 15],
            fit: true,
            toolbar: "#bannerTools",
            autoSave: true,
            onError:function(index,row){
                alert("修改失败！");
            },
            //saveUrl:,
            updateUrl: "${pageContext.request.contextPath}/changeBanner",
            //pageSize:10,
            url: '${pageContext.request.contextPath}/queryBanner',
            columns: [[
                {field: 'id', title: 'ID', width: 80},
                {field: 'picname', title: 'picname', width: 100, align: 'center', editor: "text", sortable: true},
                {field: 'picpath', title: 'Picpath', width: 80, align: 'center', editor: "text", sortable: true},
                {
                    field: 'description',
                    title: 'Description',
                    width: 80,
                    editor: "text",
                    align: 'center',
                    sortable: true
                },
                {field: 'status', title: 'Status', width: 150, editor: "text", sortable: true, align: 'center'},
                {field: 'createtime', title: 'CreateTime', width: 60, align: 'center'},
                {field: 'url', title: 'Url', width: 60, align: 'center'}
            ]],
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/cmfw_img/' + rowData.picpath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Date: ' + rowData.createtime + '</p>' +
                    '<p>Description: ' + rowData.description + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });

        $("#addBannerBtn").linkbutton({
            iconCls: "icon-add",
            plain: true,
            onClick: function () {
                $('#addBanner').dialog("open");
            }
        });
        $("#deleteBannerBtn").linkbutton({
            iconCls: "icon-reload",
            plain: true,
            onClick:function(){
                if($('#banner').edatagrid("getSelections").length === 0){
                    $.messager.show({
                        title:"advice",
                        msg:"Please choose at least one"
                    });
                }else{
                    var id = $("#banner").edatagrid("getSelected").id;
                    var picPath = $("#banner").edatagrid("getSelected").picpath;
                    $.post(
                        "${pageContext.request.contextPath}/deleteBanner",
                        {"id":id,"picPath":picPath},
                        function (res) {
                            $('#banner').edatagrid("reload");
                        },
                        "json"
                    );
                }

            }
        });
        $("#changeBannerBtn").linkbutton({
            iconCls: "icon-cut",
            plain: true,
            /*onClick:function () {
                var ban = $("#banner").edatagrid("getSelected");
                bannerId = ban.id;
                $("#changeBanner").dialog("open");
            }*/
            onClick: function () {
                //$('#banner').edatagrid("enableEditing");
                //获得选中行的行号
                if($('#banner').edatagrid("getSelections").length === 0){
                    $.messager.show({
                        title:"advice",
                        msg:"Please choose at least one"
                    });
                }else{
                    var rowIndex = $('#banner').edatagrid('getRowIndex', $('#banner').edatagrid('getSelected'));
                    console.log(rowIndex);
                    $("#banner").edatagrid("editRow", rowIndex);

                    // $("#banner").edatagrid("saveRow",rowIndex);
                }

            }
        });
        $("#changeBannerSaveBtn").linkbutton({
            iconCls:"icon-save",
            plain:true,
            onClick: function () {
                var rowIndex = $('#banner').edatagrid('getRowIndex', $('#banner').edatagrid('getSelected'));
                console.log(rowIndex);
                $("#banner").edatagrid("saveRow", rowIndex);
                $("#banner").edatagrid("reload");
            }
        });


        $("#addBanner").dialog({
            title: "Add Banner",
            width: 300,
            height: 400,
            closed: true,
            cache: false,
            href: "${pageContext.request.contextPath}/banner/banneradd.jsp",
            modal: true,
            buttons: "#addBannerTools"
        });

        $("#changeBanner").dialog({
            title: "Change Banner",
            width: 300,
            height: 400,
            closed: true,
            cache: false,
            href: "${pageContext.request.contextPath}/banner/bannerchange.jsp",
            modal: true
        });

        $("#addSub").linkbutton({
            iconCls: "icon-add",
            text: "add",
            plain: true,
            onClick: function () {
                $("#f1").form("submit", {
                    url: "${pageContext.request.contextPath}/addBanner",
                    onSubmit: function () {
                    },
                    success: function () {
                        $.messager.show({
                            title: "advice",
                            msg: "add successful!"
                        });
                        $("#addBanner").dialog("close");
                        $("#banner").edatagrid("load");
                    }
                });

            }
        });
    });

</script>

<table id="banner"></table>
<div id="bannerTools">
    <a id="addBannerBtn">Add</a>
    <a id="changeBannerBtn">Change</a>
    <a id="changeBannerSaveBtn">Save</a>
    <a id="deleteBannerBtn">Delete</a>
</div>

<div id="addBanner"></div>
<div id="addBannerTools">
    <a id="addSub">add</a>
</div>

<div id="changeBanner"></div>