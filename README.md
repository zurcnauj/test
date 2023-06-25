<h1>Resumen</h1>

<h3> Los endpoints son</h3>
<ul>
    <li>GET  /user/ : trae todos los user existentes, pero solo muestra id y email.</li>
    <li>GET  /user/{user_id} : trae un user si existe, sino retorna status 204</li>
    <li>POST /user : crea un user, retorna 201 si es posible, retorna 400 si el email esta en uso</li>
    <li>PUT /user/{user_id}/phones : agrega telefonos a un usuario existente</li>
</ul>

<p>
    postman con pruebas: test.postman_collection.json
</p>