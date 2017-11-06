function increaseBlog() {
    var namepara=$('#name').val();
    var contentpara=$('#content').val();
    $.ajax({
        url:'/MainIndex',
        type:'POST',
        data:{name:namepara,content:contentpara},
        success:function (result) {
            $("#contentShow").html(result);
        },
        error:function (xhr) {
            alert("错误提示： " + xhr.status + " " + xhr.statusText);
        }
    });

}