/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function checkPassword(form)
{
    let password = form[form.id + ":password"].value;
    let passwordConfirm = form[form.id + ":passwordConfirm"].value;
    
    if(password === passwordConfirm)
    {
        form.submit();
    }
    else
    {
        alert("Password and password confirm fields don't match");
    }
}

