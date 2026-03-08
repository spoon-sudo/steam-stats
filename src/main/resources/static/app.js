const submitBtn = document.getElementById('submitBtn');
const appIDinput = document.getElementById('userID');

submitBtn.addEventListener('click', async () => {
    let appID = appIDinput.value;

    fetch(`http://192.168.68.51:8080/stats/ownedGames/${appID}`)
        .then(response => response.json())
        .then(data => {
            const gamesList = document.getElementById('games-list');
            gamesList.innerHTML = '';

            for (let game of data.response.games) {
                const listItem = document.createElement('li');
                listItem.textContent = `${game.name} (AppID: ${game.appid}) ${game.playTimeHours} hours played`;
                gamesList.appendChild(listItem);
            }
        });
});