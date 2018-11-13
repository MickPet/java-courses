$(document).ready(function () {


    $('#addForm').submit(function (event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        ajaxPost();


    });

    function ajaxPost() {
        // PREPARE FORM DATA
        var formData = {
            name: $("#name").val(),

            password: $("#password").val(),

            roles: {
                id: $("#id").val(),
                roleName: $("#roleName").val()
            }
        };

        // DO POST
        $.ajax({
            type: "POST",
            contentType: "application/json;",
            url: "/admin/add",
            data: JSON.stringify(formData),
            dataType: 'json',
            complete: [
                function () {
                    window.location.replace("/admin");
                }
            ]
        });

    }



});