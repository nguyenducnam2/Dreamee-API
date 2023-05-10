<%@ page contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dreamee Music - Zing MP3 Vip Download</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        .card {
            margin-top: 50px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

        .card-header {
            background-color: #007bff;
            color: #fff;
        }

        .card-body {
            padding: 20px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        audio {
            width: 100%;
            height: 50px;
            background-color: #eee;
            border: none;
            outline: none;
            padding: 10px;
            margin-top: 20px;
            box-sizing: border-box;
            border-radius: 5px;
        }



        #query {
            text-align: center;
        }

    </style>
</head>

<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header text-center">
                    <h5 class="card-title">Download Zing Mp3 Audio Vip Free</h5>
                </div>
                <div class="card-body">
                    <form>
                        <div class="form-group">
                            <input type="text" class="form-control" id="query" placeholder="Nhập ID của bài hát">
                        </div>
                        <button type="button" class="btn btn-primary btn-block" onclick="filter()">Tìm kiếm</button>
                    </form>
                    <audio id="audio" controls autoplay download></audio>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    const url = "http://api.mp3.zing.vn/api/streaming/audio/";
    let query = document.getElementById('query');
    let audio = document.getElementById('audio');

    function filter() {
        audio.src = url + query.value + "/320";
        audio.hidden = false;
    }
</script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>