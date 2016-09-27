function add(user_id) {
    var content = $('#btn-input').val();
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "/toDoList",
        data: "userID=" + user_id + "&content=" + content,
        timeout: 30000,
        success: function (data) {
            $.each(data.data, function (index, toDo) {
                $("#todo-loop").append("<li id='todo-" + toDo.id + "' class='todo-list-item'>" +
                    "<div class='checkbox'><input type='checkbox' id='checkbox'/><label for='checkbox'>" + toDo.content.trim() + "</label></div>" +
                    "<div class='pull-right action-buttons'>" +
                    "<a href='javascript:void(0)' class='flag' onclick='mark(" + toDo.id + ")'><span id='flag-" + toDo.id + "' class='glyphicon glyphicon-flag'></span></a> " +
                    "<a href='javascript:void(0)' class='trash' onclick='drop(" + toDo.id + ")'><span class='glyphicon glyphicon-trash'></span></a></div></li>");
            })
            $("#btn-input").val('');
        }
    });
}

function drop(id) {
    $.ajax({
        type: "DELETE",
        dataType: "json",
        url: "/toDoList/" + id,
        timeout: 30000,
        success: function (data) {
            $("#todo-" + id).remove();
        }
    });
}

function mark(id) {
    $.ajax({
        type: "PUT",
        dataType: "json",
        url: "/toDoList/" + id,
        timeout: 30000,
        success: function (data) {
            $.each(data.data, function (index, toDo) {
                if (parseInt(toDo.is_marked) == 1) {
                    $('#flag-' + toDo.id).attr("style", "color:darkred");
                } else {
                    $('#flag-' + toDo.id).attr("style", "color:#9fadbb");
                }
            })
        }
    });
}