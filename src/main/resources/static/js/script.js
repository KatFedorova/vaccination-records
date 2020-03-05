var regBlock = document.querySelector(".reg-block");
var regFormButton = document.querySelector(".button--reg");
var regFormClose = document.querySelector(".reg-form__close");


regFormButton.addEventListener('click', function()  {
  event.preventDefault();
  regBlock.classList.add('active');
});

regFormClose.addEventListener('click', function()  {
  event.preventDefault();
  regBlock.classList.remove('active');
});
