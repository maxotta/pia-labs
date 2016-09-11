# KIV/PIA Responsive Layout Lab

This lab shows a practical example of responsive layout implementation.

During the lab you shall see:

1. Example of responsive layout implementation.
2. Create own responsive page using Twitter Bootstrap framework.

## Tasks

1. Open `bootstrap/css/boostrap.css` and examine col-xs-*, col-sm-*, col-md-*, col-lg-* classes.
1. Get familiar with Bootstrap's grid system using its [documentation](http://getbootstrap.com/css/#grid).
1. Transform `form.html` so that it matches the screenshots in the `goal` folder.

## Notes

[W3C](http://www.w3schools.com/html/html_responsive.asp) says about the responsive design this:

> Responsive Web Design makes your web page look good on all devices (desktops, tablets, and phones).
>  
>  Responsive Web Design is about using CSS and HTML to resize, hide, shrink, enlarge, or move the content to make it look good on any screen.

During examination of Bootstrap's classes, you should notice that their values are exactly the same. The only difference is
on which device width they apply: `@media (min-width: XXXpx)`. This approach allows you to specify width of your elements
based on the device on which the page is currently being displayed.

Alternatives that also provide resposnive layout:

* [Material Design](https://www.google.com/design/spec/layout/adaptive-ui.html)
* [Material Design for Angular.js](https://material.angularjs.org/latest/layout/grid)
* [Zurb Foundation](http://foundation.zurb.com/docs/components/grid.html)

## License

Base of the unstyled form has been created by Petr Picha.

This work is licensed under the Creative Commons license BY-NC-SA.

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" /></a><br /><span xmlns:dct="http://purl.org/dc/terms/" property="dct:title">Excercises for Programming of Web Applications</span> by <a xmlns:cc="http://creativecommons.org/ns#" href="http://daneka.org" property="cc:attributionName" rel="cc:attributionURL">Jakub Danek</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License</a>.
