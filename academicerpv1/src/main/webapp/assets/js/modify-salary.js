let modifysalary_form = document.getElementById('modifySalary');

modifysalary_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();

        let response = await  fetch('api/employee-salary/modifySalaryByRecord', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                id: document.getElementById('id').value,
                amount: document.getElementById('amount').value,
            })
        }).then(
            response => {
                if(response['status'] === 203){
                    document.getElementById('login-alert-success').style.display = "none";
                    document.getElementById('login-alert').style.display = "block";
                }else{
                    document.getElementById('login-alert-success').style.display = "block";
                    document.getElementById('login-alert').style.display = "none";
                }
            },
            error => {
                document.getElementById('login-alert').style.display = "block";
            }
        )
});



