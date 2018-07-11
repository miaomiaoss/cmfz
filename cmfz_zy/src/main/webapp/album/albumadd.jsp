<script type="text/javascript">

    $(function () {

        $("#aname").textbox({});
        $("#abrodecast").textbox({});
        $("#aauthor").textbox({});
        $("#acount").textbox({});
        $("#acoverpicture").filebox({});
        $("#ascore").textbox({});
        $("#acontent").textbox({});
        $("#astatus").textbox({});

    });
</script>

<form id="addAlbumForm" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>name</td>
            <td><input id="aname" name="name"></td>
        </tr>
        <tr>
            <td>brodecast</td>
            <td><input id="abrodecast" name="brodecast"></td>
        </tr>
        <tr>
            <td>author</td>
            <td><input id="aauthor" name="author"></td>
        </tr>
        <tr>
            <td>count</td>
            <td><input id="acount" name="count"></td>
        </tr>
        <tr>
            <td>coverpicture</td>
            <td><input id="acoverpicture" name="pictureFile"></td>
        </tr>
        <tr>
            <td>score</td>
            <td><input id="ascore" name="score"></td>
        </tr>
        <tr>
            <td>content</td>
            <td><input id="acontent" name="content"></td>
        </tr>
        <tr>
            <td>status</td>
            <td><input id="astatus" name="status"></td>
        </tr>

    </table>


</form>