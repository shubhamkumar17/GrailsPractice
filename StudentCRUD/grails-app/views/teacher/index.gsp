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
                <li class="nav-item active">
                    <g:link class="nav-link" action="index" controller="teacher">Home</g:link>
                </li>
                <li class="nav-item">
                    <g:link action="create" controller="teacher" class="nav-link">Add Teacher</g:link>
                </li>
            </ul>
        </nav>

        <div class="container">
            <h2>Teachers List</h2>
            <p class="btn-danger">${flash.message}</p>
            <table class="table table-view">
                <tr>
                    <th>Teacher Id</th>
                    <th>Teacher Name</th>
                    <th colspan="2">Operations</th>
                </tr>

                <g:each in="${teachers}" var="t">
                    <tr>
                        <td>${t.tid}</td>
                        <td>${t.name}</td>
                        <td>
                            <g:link class="btn btn-primary" action="edit" controller="teacher" resource="${t}">Edit</g:link>
                        </td>
                        <td>
                            <g:form method="delete" resource="${t}" action ="delete">
                                <input class="btn btn-danger" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                            </g:form>
                        </td>
                    </tr>
                </g:each>
            </table>
        </div>

    </body>
</html>