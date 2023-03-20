

async function boredApi() {
    let response = await fetch("activity");
    let data = await response.json();
    let dataText = document.getElementById("bored");
    return dataText.innerHTML = data;

}
boredApi()

