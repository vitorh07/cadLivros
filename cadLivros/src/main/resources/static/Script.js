document.getElementById('cadastroForm').addEventListener('submit', cadastrarJogo);
var result = 0;
function cadastrarLivro(event) {
event.preventDefault();

const descricao = document.getElementById('descricao').value;
const isbn = document.getElementById('isbn').value;

fetch('http://localhost:8080/livros', {
	method: 'POST',
	headers: {
	'Content-Type': 'application/json',
	},
		body: JSON.stringify({ descricao, isbn }),
	})
		.then(response => response.json())
		.then(data => {
		alert('Livro cadastrado com sucesso!');
		document.getElementById('cadastroForm').reset();
	})
.catch(error => {
		console.error('Erro ao cadastrar livro:', error);
		});
	}
function pesquisarLivro() {
	const searchId = document.getElementById('searchId').value;
	
	fetch(`http://localhost:8080/livros/${searchId}`)
	.then(response => {
	if (response.status === 404) {
	return Promise.reject('Livro não encontrado');
	result = 0;
	}
	return response.json();
	})
	.then(data => {
	result = 1;
	document.getElementById('descricao').value = `${data.descricao}`;
	document.getElementById('isbn').value = `${data.isbn}`;
	})
	.catch(error => {
	console.error('Erro ao pesquisar livro:', error);
	const resultadoPesquisa = document.getElementById('resultadoPesquisa');
	resultadoPesquisa.innerHTML = 'Livro não encontrado.';
	});
}
function atualizarLivro() {
		pesquisarLivro();
		if (result == 1) {
		const descricao = document.getElementById('descricao').value;
		const isbn = document.getElementById('isbn').value;
		const searchId = document.getElementById('searchId').value;
		
		fetch(`http://localhost:8080/livros/${searchId}`, {
		method: 'PUT',
		headers: {
		'Content-Type': 'application/json',
	},
		body: JSON.stringify({ descricao, isbn }),
	})
		.then(response => response.json())
		.then(data => {
		alert('Livro atualizado com sucesso!');
		document.getElementById('cadastroForm').reset();
	})
		.catch(error => {
		console.error('Erro ao atualizar livro:', error);
	});
	} else {
		alert('ID não encontrado na base de dados. Nenhum livro foi alterado. Favor pesquisar livro a ser alterado !!!');
	}
}
function excluirLivro() {
		pesquisarLivro();
		if (result == 1) {
		const descricao = document.getElementById('descricao').value;
		const isbn = document.getElementById('isbn').value;
		const searchId = document.getElementById('searchId').value;
		
		fetch(`http://localhost:8080/livros/${searchId}`, {
		method: 'DELETE',
		headers: {
		'Content-Type': 'application/json',
	},
		body: JSON.stringify({ descricao, isbn }),
	})
		.then(response => response.json())
		.then(data => {
		alert('Livro excluído com sucesso!');
		document.getElementById('cadastroForm').reset();
	})
		.catch(error => {
		console.error('Erro ao excluir livro:', error);
	});
}
}