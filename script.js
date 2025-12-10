const base = "http://localhost:8080";

function addSong() {
    const song = document.getElementById("songInput").value.trim();
    if (!song) return; // no empty songs

    fetch(`${base}/add?name=${encodeURIComponent(song)}`)
        .then(showPlaylist)
        .catch(err => console.error("Add error:", err));
}

function removeSong() {
    const song = document.getElementById("songInput").value.trim();
    if (!song) return;

    fetch(`${base}/remove?name=${encodeURIComponent(song)}`)
        .then(showPlaylist)
        .catch(err => console.error("Remove error:", err));
}

function nextSong() {
    fetch(`${base}/next`)
        .then(showPlaylist)
        .catch(err => console.error("Next error:", err));
}

function prevSong() {
    fetch(`${base}/prev`)
        .then(() => showPlaylist());
}

function showPlaylist() {
    fetch(`${base}/list`).then(show);
}


function show(response) {
    response.text().then(text => {
        document.getElementById("output").value = text;
    });
}
