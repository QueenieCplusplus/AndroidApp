# git_err_fix

url deny permission, return 403

The requested URL returned error: 403

    $cd project
    $vim .git/config
    
    esc
    i

    from
    [remote "origin"]  
        url = https://github.com/bbb/example.git  

    to
    [remote "origin"]  
        url = https://bbb@github.com/bbb/example.git  

    esc
    :wq

    $git push

