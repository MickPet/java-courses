function updatePost(userId) {


    $('#' + userId).submit(function (event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        ajaxPostUpdate(userId);
    });

    function ajaxPostUpdate(userId) {
        // PREPARE FORM DATA
        var formDataUpdate = {
            id: userId,
            name: $("#name" + userId).val(),
            password: $("#password" + userId).val(),
            roles: {
                id: $("#id" + userId).val(),
                roleName: $("#roleName" + userId).val()
            }
        };

        // DO POST
        $.ajax({
            type: "POST",
            contentType: "application/json;",
            url: "/admin/update",
            data: JSON.stringify(formDataUpdate),
            dataType: 'json',
            complete: [
                function () {
                    window.location.replace("/admin");
                }
            ]
        });

    }
}