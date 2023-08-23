let ip;

const reload = () => {
  location.reload();
}

const post = () => {
  let result = document.getElementById("result");
  result.innerText = "";

  ip = document.getElementById("ip").value;
  let name = document.getElementById("name").value;
  let title = document.getElementById("title").value;
  let description = document.getElementById("description").value;

  const message = {
    title: title,
    description: description,
    name: name
  }

  fetch("http://" + ip + ":8080/message", {method: "POST", body: JSON.stringify(message)})
  .then(() => result.innerText = "Success")
  .catch(() => result.innerText = "Error")
}

setInterval(() => {

  fetch("http://" + ip + ":8080/message").then(data => {

    data.json().then(json => {

      let html = "";
      json.forEach(message => {
        html += `
        <div class="board-message">
          <div class="board-message__head">
            <h6>${message.title}</h6>
            <p>${message.person.name} : ${message.person.ip}</p>
          </div>
          <p>${message.description}</p>
        </div>`
      })
      document.getElementById("messages").innerHTML = html
    })

  })
}, 2000)
