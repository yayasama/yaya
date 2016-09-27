function add() {
    var content = $('#btn-input').val();
    if (content.trim() == '') {
        return false;
    }
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "/category",
        data: "name=" + content,
        timeout: 30000,
        success: function (data) {
            $.each(data.data, function (index, category) {
                $("#category-loop").append(
                    "<tr><td class='bs-checkbox'><input data-index='0' name='toolbar1' type='checkbox'></td> <td>" + category.id + "</td> <td>" + category.name + "</td> <td> <a href='/category/" + category.id + "/edit'>编辑</a>|<a href='/category/" + category.id + "/delete'>删除</a> </td> </tr>")
            })
            $("#btn-input").val('');
        }
    });
}
