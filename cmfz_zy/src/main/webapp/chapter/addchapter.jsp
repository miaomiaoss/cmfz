<%@page contentType="text/html; charset=utf-8" %>
<script type="text/javascript">

    $(function () {

        $("#albumId").textbox({
            editable:true
        });

        $("#chapterfile").filebox({});

        $("#addChapterForm").form("load",{
            albumId:albumId
        });

    });
</script>

<form id="addChapterForm" method="post" enctype="multipart/form-data">
    专辑ID:<input id="albumId" name="albumId"><br/>
    选择章节:<input id="chapterfile" name="mpFile" /><br/>
</form>