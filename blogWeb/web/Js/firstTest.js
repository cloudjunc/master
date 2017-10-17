function test(){
    alert("Hello js");
//     $.post({
//         url: "/User"
// })
//     $("#ttt").hide();
    // $.get("demo_test.asp",function(data,status){
    //     alert("Data: " + data + "\nStatus: " + status);
    // });
    $.ajax({
        url:"/User",
        type:"GET",
        success:function (result) {
            alert("成功：");
            $("#div1").html(result);
        },
        error:function (xhr) {
            alert("错误提示： " + xhr.status + " " + xhr.statusText);
        }

    })
}
