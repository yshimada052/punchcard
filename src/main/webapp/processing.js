document.getElementById('login').addEventListener('submit', function(e){
    e.preventDefault();  //stops expecting a page refresh
    let user = {
        name: document.getElementById('userId').value
    };
    
    let api = `http://localhost:8080/punchcard/api/userId?id=$(id)`;
    let url = 'http://localhost:8080/punchcard/api/user';
    
    let promise =  axios.post(url, artist);
      
    //promise.then(function(response){  
    promise.then(response =>{
        
        console.log(response);
        
        appendArtist(response.data);
        //clear the form
        document.getElementById('useId').value = null;
    });
    //another callback for a failed response
    promise.catch(function(response){
        //4xx or 5xx
        console.log(response);
    });
    //axios.post('','').then(function(){}).catch(function(){});
});


document.addEventListener('DOMContentLoaded', function(){
    //ajax call (XMLHttpRequest: xhr) to fetch artists
    var xhr = new XMLHttpRequest();
    //readystate 0
    xhr.open('POST', 'http://localhost:8080/punchcard/api/');
    //ready state 1
    xhr.onreadystatechange = function(){
        console.log(xhr.readyState);
        if(xhr.readyState === 4 && xhr.status === 200){
            //parse HTTP response boy
            var json = JSON.parse(xhr.responseText);
            console.log(json);
            artistification(json);
        }
    };

    xhr.send(); //creating HTTP request, and send to server async
    //readystate 2 - hreaders reeived
    //ready state 3 - reaspnse Text has partial data
    //ready state 4 - xhr request DONE
    console.log('Sent');
});
;

function artistification(list){
    for(let user of list){
        appendUser(user);
    }

};

function appendArtist(user){
    let tr = document.createElement('tr');
    let id = document.createElement('td');
    id.innerText = artist.artistId;
    let name = document.createElement('td');
    name.innerText = user.name;
    tr.appendChild(id);
    //tr.appendChild(name);
    document.getElementById('list').appendChild(tr);
};