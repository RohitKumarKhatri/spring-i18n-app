<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Greeting</title>
</head>
<body>
<#if errorMessage??>
    <h1>${errorMessage}</h1>
<#else>
    <h1>${greeting} ${userName}!</h1>
    <h2>Account Balance: ${accountBalance}</h2>
    <h2>Date of Birth: ${dateOfBirth}</h2>
</#if>

</body>
</html>
