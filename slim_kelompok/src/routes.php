<?php

use Slim\App;
use Slim\Http\Request;
use Slim\Http\Response;

return function (App $app) {
    $container = $app->getContainer();

    // $app->get('/[{name}]', function (Request $request, Response $response, array $args) use ($container) {
    //     // Sample log message
    //     $container->get('logger')->info("Slim-Skeleton '/' route");

    //     // Render index view
    //     return $container->get('renderer')->render($response, 'index.phtml', $args);
    // });

    //Akun Pengguna
    $app->post('/createUser', function (Request $request, Response $response, $args) {

        $data = $request->getParsedBody();
        $query = "INSERT INTO pengguna (nik, nama, gender, tanggal_lahir, email, password, alamat, peran) VALUE (:nik, :nama, :gender, :tanggal_lahir, :email, :password, :alamat, :peran)";

        $stmt = $this->db->prepare($query);

        $data = [
            ":nik" => $data["nik"],
            ":nama" => $data["nama"],
            ":gender" => $data["gender"],
            ":tanggal_lahir" => $data["tanggal_lahir"],
            ":email" => $data["email"],
            ":password" => $data["password"],
            ":alamat" => $data["alamat"],
            ":peran" => $data["peran"]
        ];

        if ($stmt->execute($data))
            return $response->withJson(["status" => "success created",  "data" => "1"], 200);
        else
            return $response->withJson(["status" => "failed", "data" => "0"], 200);
    });




    $app->post("/userLogin", function (Request $request, Response $response) {

        $data = $request->getParsedBody();

        $email = $data['email'];
        $password = $data['password'];

        $query = "SELECT * FROM pengguna WHERE email = '$email' AND password = '$password'";
        $stmt = $this->db->prepare($query);
        $stmt->execute();
        $result = $stmt->fetch();
        if ($result['email'] != null) {
            if ($result['peran'] == 'admin') {
                return $response->withJson(["status" => "Admin Login succesfully", "email" => $result['email'], "password" => $result['password']], 200);
            } else if ($result['peran'] == 'masyarakat') {
                return $response->withJson(["status" => "Masyarakat Login succesfully", "email" => $result['email'], "password" => $result['password']], 200);
            }
        } else {
            return $response->withJson(["status" => "failed login"], 200);
        }
    });

    $app->get("/allUser", function (Request $request, Response $response) {
        $response = array();
        $query = "SELECT * FROM pengguna";
        $stmt = $this->db->prepare($query);
        $stmt->execute();
        $result = $stmt;

        $response["error"] = false;
        $response["pengguna"] = array();

        while ($strData = $result->fetch()) {
            $tmp = array();
            $tmp["id"] = utf8_encode($strData["id"]);
            $tmp["nik"] = utf8_encode($strData["nik"]);
            $tmp["nama"] = utf8_encode($strData["nama"]);
            $tmp["gender"] = utf8_encode($strData["gender"]);
            $tmp["tanggal_lahir"] = utf8_encode($strData["tanggal_lahir"]);
            $tmp["email"] = utf8_encode($strData["email"]);
            $tmp["password"] = utf8_encode($strData["password"]);
            $tmp["alamat"] = utf8_encode($strData["alamat"]);
            $tmp["peran"] = utf8_encode($strData["peran"]);
            array_push($response["pengguna"], $tmp);
        }

        echo json_encode($response);
    });

    $app->post('/updateUser', function (Request $request, Response $response, $args) {
        $pengguna = $request->getParsedBody();
        $query = "UPDATE pengguna SET nik=:nik, nama=:nama, gender=:gender, tanggal_lahir=:tanggal_lahir, email=:email, password=:password, alamat=:alamat, peran=:peran WHERE id=:id";
        $stmt = $this->db->prepare($query);

        $data = [
            "id" => $pengguna["id"],
            "nik" => $pengguna["nik"],
            "nama" => $pengguna["nama"],
            "gender" => $pengguna["gender"],
            "tanggal_lahir" => $pengguna["tanggal_lahir"],
            "email" => $pengguna["email"],
            "password" => $pengguna["password"],
            "alamat" => $pengguna["alamat"],
            "peran" => $pengguna["peran"],
        ];

        if ($stmt->execute($data))
            return $response->withJson(["status" => "succesfully", "data" => "1"], 200);
        else
            return $response->withJson(["status" => "failed data", "data" => "0"], 200);
    });

    $app->get('/deleteUser/{id}', function (Request $request, Response $response, $args) {
        $id = $args["id"];
        $query = "DELETE FROM pengguna WHERE id=:id";
        $stmt = $this->db->prepare($query);

        $data = [
            ":id" => $id
        ];

        if ($stmt->execute($data))
            return $response->withJson(["status" => "Succesfully delete data", "data" => "1"], 200);
        else
            return $response->withJson->withJson(["status" => "failed data", "data" => "0"], 200);
    });


    //Kelola Informasi
    $app->post('/createInfo', function (Request $request, Response $response, $args) {

        $data = $request->getParsedBody();
        $query = "INSERT INTO info (tanggal, judul, isi_info) VALUE (:tanggal, :judul, :isi_info)";

        $stmt = $this->db->prepare($query);

        $data = [
            ":tanggal" => $data["tanggal"],
            ":judul" => $data["judul"],
            ":isi_info" => $data["isi_info"]
        ];

        if ($stmt->execute($data))
            return $response->withJson(["status" => "success created",  "data" => "1"], 200);
        else
            return $response->withJson(["status" => "failed", "data" => "0"], 200);
    });


    $app->get("/allInfo", function (Request $request, Response $response) {
        $response = array();
        $query = "SELECT * FROM info";
        $stmt = $this->db->prepare($query);
        $stmt->execute();
        $result = $stmt;

        $response["error"] = false;
        $response["info"] = array();

        while ($strData = $result->fetch()) {
            $tmp = array();
            $tmp["id"] = utf8_encode($strData["id"]);
            $tmp["tanggal"] = utf8_encode($strData["tanggal"]);
            $tmp["judul"] = utf8_encode($strData["judul"]);
            $tmp["isi_info"] = utf8_encode($strData["isi_info"]);
            array_push($response["info"], $tmp);
        }

        echo json_encode($response);
    });


    $app->post('/updateInfo', function (Request $request, Response $response, $args) {
        $info = $request->getParsedBody();
        $query = "UPDATE info SET tanggal=:tanggal, judul=:judul, isi_info=:isi_info WHERE id=:id";
        $stmt = $this->db->prepare($query);

        $data = [
            "id" => $info["id"],
            "tanggal" => $info["tanggal"],
            "judul" => $info["judul"],
            "isi_info" => $info["isi_info"],

        ];

        if ($stmt->execute($data))
            return $response->withJson(["status" => "succesfully", "data" => "1"], 200);
        else
            return $response->withJson(["status" => "failed data", "data" => "0"], 200);
    });


    $app->get('/deleteInfo/{id}', function (Request $request, Response $response, $args) {
        $id = $args["id"];
        $query = "DELETE FROM info WHERE id=:id";
        $stmt = $this->db->prepare($query);

        $data = [
            ":id" => $id
        ];

        if ($stmt->execute($data))
            return $response->withJson(["status" => "Succesfully delete data", "data" => "1"], 200);
        else
            return $response->withJson->withJson(["status" => "failed data", "data" => "0"], 200);
    });

    //Kelola ODP
    $app->post('/createOdp', function (Request $request, Response $response, $args) {

        $data = $request->getParsedBody();
        $query = "INSERT INTO odp (tanggal, jumlah) VALUE (:tanggal, :jumlah)";

        $stmt = $this->db->prepare($query);

        $data = [
            ":tanggal" => $data["tanggal"],
            ":jumlah" => $data["jumlah"]
        ];

        if ($stmt->execute($data))
            return $response->withJson(["status" => "success created",  "data" => "1"], 200);
        else
            return $response->withJson(["status" => "failed", "data" => "0"], 200);
    });


    $app->get("/allOdp", function (Request $request, Response $response) {
        $response = array();
        $query = "SELECT * FROM odp";
        $stmt = $this->db->prepare($query);
        $stmt->execute();
        $result = $stmt;

        $response["error"] = false;
        $response["odp"] = array();

        while ($strData = $result->fetch()) {
            $tmp = array();
            $tmp["id"] = utf8_encode($strData["id"]);
            $tmp["tanggal"] = utf8_encode($strData["tanggal"]);
            $tmp["jumlah"] = utf8_encode($strData["jumlah"]);
            array_push($response["odp"], $tmp);
        }

        echo json_encode($response);
    });


    $app->post('/updateOdp', function (Request $request, Response $response, $args) {
        $odp = $request->getParsedBody();
        $query = "UPDATE odp SET tanggal=:tanggal, jumlah=:jumlah WHERE id=:id";
        $stmt = $this->db->prepare($query);

        $data = [
            "id" => $odp["id"],
            "tanggal" => $odp["tanggal"],
            "jumlah" => $odp["jumlah"]

        ];

        if ($stmt->execute($data))
            return $response->withJson(["status" => "succesfully", "data" => "1"], 200);
        else
            return $response->withJson(["status" => "failed data", "data" => "0"], 200);
    });


    $app->get('/deleteOdp/{id}', function (Request $request, Response $response, $args) {
        $id = $args["id"];
        $query = "DELETE FROM odp WHERE id=:id";
        $stmt = $this->db->prepare($query);

        $data = [
            ":id" => $id
        ];

        if ($stmt->execute($data))
            return $response->withJson(["status" => "Succesfully delete data", "data" => "1"], 200);
        else
            return $response->withJson->withJson(["status" => "failed data", "data" => "0"], 200);
    });

    //Kelola PDP
    $app->post('/createPdp', function (Request $request, Response $response, $args) {

        $data = $request->getParsedBody();
        $query = "INSERT INTO pdp (tanggal, jumlah) VALUE (:tanggal, :jumlah)";

        $stmt = $this->db->prepare($query);

        $data = [
            ":tanggal" => $data["tanggal"],
            ":jumlah" => $data["jumlah"]
        ];

        if ($stmt->execute($data))
            return $response->withJson(["status" => "success created",  "data" => "1"], 200);
        else
            return $response->withJson(["status" => "failed", "data" => "0"], 200);
    });


    $app->get("/allPdp", function (Request $request, Response $response) {
        $response = array();
        $query = "SELECT * FROM pdp";
        $stmt = $this->db->prepare($query);
        $stmt->execute();
        $result = $stmt;

        $response["error"] = false;
        $response["pdp"] = array();

        while ($strData = $result->fetch()) {
            $tmp = array();
            $tmp["id"] = utf8_encode($strData["id"]);
            $tmp["tanggal"] = utf8_encode($strData["tanggal"]);
            $tmp["jumlah"] = utf8_encode($strData["jumlah"]);
            array_push($response["pdp"], $tmp);
        }

        echo json_encode($response);
    });


    $app->post('/updatePdp', function (Request $request, Response $response, $args) {
        $pdp = $request->getParsedBody();
        $query = "UPDATE pdp SET tanggal=:tanggal, jumlah=:jumlah WHERE id=:id";
        $stmt = $this->db->prepare($query);

        $data = [
            "id" => $pdp["id"],
            "tanggal" => $pdp["tanggal"],
            "jumlah" => $pdp["jumlah"]

        ];

        if ($stmt->execute($data))
            return $response->withJson(["status" => "succesfully", "data" => "1"], 200);
        else
            return $response->withJson(["status" => "failed data", "data" => "0"], 200);
    });


    $app->get('/deletePdp/{id}', function (Request $request, Response $response, $args) {
        $id = $args["id"];
        $query = "DELETE FROM pdp WHERE id=:id";
        $stmt = $this->db->prepare($query);

        $data = [
            ":id" => $id
        ];

        if ($stmt->execute($data))
            return $response->withJson(["status" => "Succesfully delete data", "data" => "1"], 200);
        else
            return $response->withJson->withJson(["status" => "failed data", "data" => "0"], 200);
    });
};
