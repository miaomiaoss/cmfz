<%@page contentType="text/html;charset=utf-8" %>
<script type="text/javascript">
    var album;
    var albumId;
    $(function () {
        $('#album').treegrid({
            title:"专辑",
            animate:true,
            //collapsible:true,
            fitColumns:true,
            //showFooter:true,
            //checkbox:true,
            pagination:true,
            pageList:[1,3,5,10,15],
            url:'${pageContext.request.contextPath}/queryAlbum',
            idField:'id',
            treeField:"name",
            toolbar:"#albumTools",
            columns:[[
                {title:'名字',field:'name',width:180},
                {field:'path',title:'下载路径',width:60,align:'center'},
                {field:'size',title:'章节大小',width:80,align:'center'},
                {field:'length',title:'章节时长',width:80,align:'center'},
                {field:'times',title:'下载次数',width:80,align:'center'}
            ]]
        });

        $("#albumDetailsBtn").linkbutton({
            iconCls:"icon-search",
            plain:true,
            onClick:function () {
                album = $('#album').treegrid("getSelected");
                console.log(album);
                console.log(album.name);

                $("#albumDetailsDialog").dialog("open");
                //$('#albumDetailTable').datagrid("reload");
            }
        });

        $("#addAlbumBtn").linkbutton({
            iconCls:"icon-add",
            plain:true,
            onClick:function () {
                $
                $("#addalbumDialog").dialog("open");
            }
        });

        $("#addChapterBtn").linkbutton({
            iconCls:"icon-add",
            plain:true,
            onClick:function () {
                albumId = $('#album').treegrid("getSelected").id;
                console.log(albumId);
                $("#addchapterDialog").dialog("open");
            }

        });

        $("#addchapterDialog").dialog({
            title: 'Add Chapter',
            width: 300,
            height: 400,
            closed: true,
            cache: false,
            href:"${pageContext.request.contextPath}/chapter/addchapter.jsp",
            modal:true,
            buttons:"#addChapterSub"
        });

        $("#addChapterSubBtn").linkbutton({
            iconCls:"icon-add",
            plain:true,
            onClick:function () {
                $("#addChapterForm").form("submit",{
                    url:"${pageContext.request.contextPath}/addchapter",
                    onSubmit: function () {
                    },
                    success: function (){
                        $.messager.show({
                            title:"Advice",
                            msg:"添加章节成功"
                        });
                        $("#addchapterDialog").dialog("close");
                        $("#album").treegrid("reload");
                    }
                })
            }
        });

        $("#addalbumDialog").dialog({
            title: 'Add Album',
            width: 300,
            height: 400,
            closed: true,
            cache: false,
            href:"${pageContext.request.contextPath}/album/albumadd.jsp",
            modal:true,
            buttons:"#addAlbumSub"
        });

        $("#addAlbumSubBtn").linkbutton({
            iconCls:"icon-add",
            onClick:function () {
                $("#addAlbumForm").form("submit",{
                    url:"${pageContext.request.contextPath}/insertAlbum",
                    onSubmit: function () {
                    },
                    success: function (){
                        $.messager.show({
                            title:"Advice",
                            msg:"添加专辑成功"
                        });
                        $("#addalbumDialog").dialog("close");
                        $("#album").treegrid("reload");
                    }
                })
            }
        });

        $("#downloadMusicBtn").linkbutton({
            iconCls:"icon-add",
            plain:true,
            onClick:function () {
                var album = $("#album").treegrid("getSelected");
                var path = album.path;
                var name = album.name;
                console.log(path);
                console.log(name);
               /*$.post(
                   "",
                   {"path":path}
               );*/
               location.href = "${pageContext.request.contextPath}/downloadChapter?path="+path+"&name="+name;
            }
        });

        $("#albumDetailsDialog").dialog({
            title: 'Album Details',
            width: 900,
            height: 200,
            closed: true,
            cache: false,
            href: '${pageContext.request.contextPath}/album/albumdetails.jsp',
            modal: true
        });
    });

</script>

<table id="album"></table>

<div id="albumDetailsDialog"></div>
<div id="addalbumDialog"></div>
<div id="addchapterDialog"></div>
<div id="addChapterSub">
    <a id="addChapterSubBtn">添加</a>
</div>

<div id="addAlbumSub">
    <a id="addAlbumSubBtn">添加</a>
</div>


<div id="albumTools">
    <a id="albumDetailsBtn">专辑详情</a>
    <a id="addAlbumBtn">添加专辑</a>
    <a id="addChapterBtn">添加章节</a>
    <a id="downloadMusicBtn">下载音频</a>
</div>