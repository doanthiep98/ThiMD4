let table = document.getElementById("listProvince");
getAllProvince();

function getAllProvince(){
    $.ajax({
        type:"GET",
        url:"http://localhost:8080/province",
        success :function (data) {
            displayTable(data);
        }
    })
}
function displayTable(data){
    let result = ""
    for (let i = 0; i < data.length; i++) {
        result +="<tr >"
        result+="<td >"+ i+1 +"</td>"
        result+="<td><a onclick='showEditForm2("+data[i].id+")'>"+ data[i].name +"</a></td>"
        result+="<td>"+ data[i].country.name +"</td>"
        result+="<td><button onclick='showEditForm("+data[i].id+")'>Update</button></td>"
        result+="<td><button onclick='deleteComfirm("+data[i].id+")'>Delete</button></td>"
        result +="</tr>"
    }
    table.innerHTML = result;

}

function showCreate(){
    $('#exampleModal').modal('show');
    listCountry()
}



function createProvince(){
    let name = $('#name').val();
    let area = $('#area').val();
    let population = $('#population').val();
    let gdp = $('#gdp').val();
    let country = $('#country').val();
    let introduce = $('#introduce').val();
    let province ={
        name : name,
        area : area,
        population : population,
        introduce : introduce,
        gdp : gdp,
        country : {
            id : country
        },

    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: "http://localhost:8080/province",
        data: JSON.stringify(province),
        success:function (){
        getAllProvince();
        alert("Tạo thành công!");
        $('#exampleModal').modal('hide');
        document.getElementById("addForm").reset()
        }
    })
    event.preventDefault()
}


function listCountry(){
$.ajax({
type:"GET",
    url:"http://localhost:8080/countries",
    success: function (listCountry){
    result = ""
        for (let i = 0; i < listCountry.length; i++) {
            result += "<option value="+listCountry[i].id+">"+ listCountry[i].name +"</option>"
        }
        document.getElementById("country").innerHTML = result;
        document.getElementById("country1").innerHTML = result;
        // document.getElementById("country1").innerHTML = result;
    }
})
}



function deleteComfirm(id){
    let result = confirm("Bạn có muốn xóa không?")
    if (result){
        deleteProvince(id);
    }
}
function deleteProvince(id){
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/province/"+ id,
        success: function (){
            getAllProvince()
            alert("Xóa thành công")
        }
    })
}

let idProvince;
function showEditForm(id){

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/province/" + id,
        success: function (data) {
            localStorage = data.id
            idProvince = data.id;
            document.getElementById("name1").value = data.name
            document.getElementById("country1").value = data.country.name
            document.getElementById("area1").value = data.area
            document.getElementById("population1").value = data.population
            document.getElementById("gdp1").value = data.gdp
            document.getElementById("introduce1").value = data.introduce
            listCountry()
        }
    })
    $('#exampleModal1').modal('show');
}
function showEditForm2(id){

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/province/" + id,
        success: function (data) {
            idProvince = data.id;
            document.getElementById("name2").value = data.name
            document.getElementById("country2").value = data.country.name
            document.getElementById("area2").value = data.area
            document.getElementById("population2").value = data.population
            document.getElementById("gdp2").value = data.gdp
            document.getElementById("introduce2").value = data.introduce
            listCountry()
        }
    })
    $('#exampleModal2').modal('show');
}



function updateProvince(){
    let name = $('#name1').val();
    let area = $('#area1').val();
    let population = $('#population1').val();
    let gdp = $('#gdp1').val();
    let country = $('#country1').val();
    let introduce = $('#introduce1').val();
    let province ={
        id: idProvince,
        name : name,
        area : area,
        population : population,
        introduce : introduce,
        gdp : gdp,
        country : {
            id : country
        },

    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        url: "http://localhost:8080/province/" + idProvince,
        data: JSON.stringify(province),
        success:function (){
            getAllProvince();
            alert("Sửa thành công!");
            $('#exampleModal1').modal('hide');
            document.getElementById("editForm").reset()
        }
    })
    event.preventDefault()
}


