function increaseBlog() {
    var namepara=$('#name').val();
    var contentpara=$('#content').val();
    $.ajax({
        url:'/MainIndex',
        type:'POST',
        data:{name:namepara,content:contentpara},
        success:function (result) {
            // $("#contentShow").html(result);
            var x=eval("("+result+")");
            var str=BuildContentDiv(x);
            $("#contentShow").html(str);
            // alert(result);
        },
        error:function (xhr) {
            alert("错误提示： " + xhr.status + " " + xhr.statusText);
        }
    });

}

function BuildContentDiv(jobjArray){
    var str="<div id='contentShow'>"
    jobjArray.forEach(function(value,index,array){
        str+="<div class='bbl'>"
        str+= "<h2>"+value.name+"</h2>"
        str+= "<p>"+value.content+"</p>"
        str+="</div>"
    })
    str+="</div>"
    return str
}
