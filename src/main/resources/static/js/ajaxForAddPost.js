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

            pass: $("#pass").val(),

            role: {
                roleId: $("#roleId").val(),
                authority: $("#authority").val()
            }
        };

        // DO POST
        $.ajax({
            type: "POST",
            contentType: "application/json;",
            url: "/add",
            data: JSON.stringify(formData),
            dataType: 'json',
            complete: [
                function () {
                    window.location.replace("/list");
                }
            ]
        });

    }



});