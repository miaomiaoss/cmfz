<%@page contentType="text/html;charset=utf-8" %>
<script type="text/javascript">

    $(function () {
        $("#picname").textbox({});

        $('#picpath').filebox({
            buttonText: '选择文件',
            buttonAlign: 'right'
        });

        $("#description").textbox({
            multiline: true,
            height: 40
        });
        $("#url").textbox({});
        $("#status").combobox({
            url:'${pageContext.request.contextPath}/banner/bannerstatus.jsp',
            valueField:'id',
            textField:'text'
        });
    });
</script>

<form id="f1" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>PicName:</td>
            <td><input id="picname" name="picname"></td>
        </tr>
        <tr>
            <td>Picpath:</td>
            <td><input id="picpath" name="pictureFile"></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><input id="description" name="description"></td>
        </tr>
        <tr>
            <td>Status:</td>
            <td><input id="status" name="status"></td>
        </tr>
        <tr>
            <td>Url:</td>
            <td><input id="url" name="url"></td>
        </tr>
    </table>
</form>