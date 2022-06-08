<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.rewebclient.entity.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Product> list = (ArrayList<Product>) request.getAttribute("listProduct");
    if (list == null) {
        list = new ArrayList<>();
    }

%>
<html>
<head>
    <title>Foods</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<ul class="nav align-items-center">
    <li class="nav-item">
        <a class="nav-link active" href="/"> <img src="../../Image/E6ZdPfXX0AAn-vN.jpg" width="100"
                                                  class="rounded-circle">
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/products">Product</a>
    </li>

</ul>
<div class="container">

    <a href="/products/create" class="btn btn-outline-primary float-right">Create</a>

    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Product name</th>
            <th scope="col">Price</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Product food : list
            ) {%>
        <tr>
            <td><%=food.getId()%>
            </td>
            <td><%=food.getName()%>
            </td>

            <td><%=food.getPrice()%> VND</td>
            <td>
                <%--                <button>Detail</button>--%>
                <a href="/products/detail?id=<%=food.getId()%>" class="btn btn-outline-primary">Detail</a>

                <a href="/products/update?id=<%=food.getId()%>" class="btn btn-outline-success">Update</a>
                <a href="/products/delete?id=<%=food.getId()%>"
                   class="btn btn-outline-danger btn-delete">Delete</a>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>


</div>
</body>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        let listDeleteBtn = document.querySelectorAll('.btn-delete');
        for (let i = 0; i < listDeleteBtn.length; i++) {
            listDeleteBtn[i].addEventListener('click', function (event) {
                event.preventDefault();
                if (confirm("Are U sure?")) {
                    let xhr = new XMLHttpRequest();
                    xhr.onreadystatechange = function () {
                        if (xhr.readyState == 4 && xhr.status == 200) {
                            alert("Deleted!")
                            window.location.reload()
                        }
                    }
                    xhr.open('DELETE', this.href, false);
                    xhr.send();
                }
            })
        }
    })
</script>
</html>
