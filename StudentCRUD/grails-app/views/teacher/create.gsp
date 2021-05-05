<!DOCTYPE html>
<html>
    <head>
        <title>Teacher | Homepage</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <g:link class="nav-link" action="index" controller="teacher">Home</g:link>
                </li>
                <li class="nav-item active">
                    <g:link action="create" controller="teacher" class="nav-link">Add Teacher</g:link>
                </li>
            </ul>
        </nav>

        <div class="container">
            <h2>Add Teacher</h2>
            <p class="btn-danger disabled"><%= flash.message %></p>
            <g:form action="save" controller="teacher" method="POST">
                <label for="tid">Teacher Id: </label><g:textField name="tid"/><br>
                <label for="name">Teacher Name: </label><g:textField name="name"/><br>
                <g:submitButton name="submit"/>
            </g:form>
        </div>

    </body>
</html>