$(document).ready(function(){

    // Full featured editor

    $('#editor1,#editor2,#editor3').each( function(index, element)

    {

        $(element).wysiwyg({

            classes: 'some-more-classes',

            position: index == 0 ? 'top-selection' : (index == 1 ? 'bottom' : 'selection'),

            buttons: {

                // Dummy-HTML-Plugin

                dummybutton1: index != 1 ? false : {

                    html: $('<input id="submit" type="button" value="bold" />').click(function(){

                                // We simply make 'bold'

                                if( $(element).wysiwyg('selected-html') )

                                    $(element).wysiwyg('bold');

                                else

                                    alert( 'Please selection some text' );

                            }),

                    //showstatic: true,    // wanted on the toolbar

                    showselection: false    // wanted on selection

                },

                // Dummy-Button-Plugin

                dummybutton2: index != 1 ? false : {

                    title: 'Dummy',

                    image: '\uf1e7',

                    click: function( $button ) {

                            alert('Do something');

                           },

                    //showstatic: true,    // wanted on the toolbar

                    showselection: false    // wanted on selection

                },

                // Smiley-Plugin

                smilies: {

                    title: '表情',

                    image: '\uf118', // <img src="path/to/image.png" width="16" height="16" alt="" />

                    popup: function( $popup, $button, $editor ) {

                            var list_smilies = [

                                    '<img src="static/images/smiley/afraid.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/amorous.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/angel.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/angry.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/bored.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/cold.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/confused.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/cross.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/crying.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/devil.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/disappointed.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/dont-know.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/drool.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/embarrassed.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/excited.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/excruciating.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/eyeroll.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/happy.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/hot.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/hug-left.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/hug-right.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/hungry.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/invincible.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/kiss.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/lying.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/meeting.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/nerdy.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/neutral.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/party.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/pirate.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/pissed-off.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/question.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/sad.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/shame.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/shocked.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/shut-mouth.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/sick.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/silent.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/sleeping.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/sleepy.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/stressed.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/thinking.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/tongue.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/uhm-yeah.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/wink.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/working.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/bathing.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/beer.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/boy.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/camera.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/chilli.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/cigarette.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/cinema.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/coffee.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/girl.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/console.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/grumpy.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/in_love.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/internet.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/lamp.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/mobile.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/mrgreen.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/musical-note.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/music.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/phone.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/plate.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/restroom.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/rose.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/search.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/shopping.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/star.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/studying.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/suit.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/surfing.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/thunder.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/tv.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/typing.png" width="16" height="16" alt="" />',

                                    '<img src="static/images/smiley/writing.png" width="16" height="16" alt="" />'

                            ];

                            var $smilies = $('<div/>').addClass('wysiwyg-toolbar-smilies')

                                                      .attr('unselectable','on');

                            $.each( list_smilies, function(index,smiley){

                                if( index != 0 )

                                    $smilies.append(' ');

                                var $image = $(smiley).attr('unselectable','on');

                                // Append smiley

                                var imagehtml = ' '+$('<div/>').append($image.clone()).html()+' ';

                                $image

                                    .css({ cursor: 'pointer' })

                                    .click(function(event){

                                        $(element).wysiwyg('inserthtml',imagehtml);

                                        // do not close popup

                                        //$(element).wysiwyg('close-popup');

                                    })

                                    .appendTo( $smilies );

                            });

                            $smilies.css({ maxWidth: parseInt($editor.width()*0.95)+'px' });

                            $popup.append( $smilies );

                            // Smilies do not close on click, so force the popup-position to cover the toolbar

                            var $toolbar = $button.parents( '.wysiwyg-toolbar' );

                            if( ! $toolbar.length ) // selection toolbar?

                                return ;

                            var left = 0,

                                top = 0,

                                node = $toolbar.get(0);

                            while( node )

                            {

                                left += node.offsetLeft;

                                top += node.offsetTop;

                                node = node.offsetParent;

                            }

                            left += parseInt( ($toolbar.outerWidth() - $popup.outerWidth()) / 2 );

                            if( $toolbar.hasClass('wysiwyg-toolbar-top') )

                                top -= $popup.height() - parseInt($button.outerHeight() * 1/4);

                            else

                                top += parseInt($button.outerHeight() * 3/4);

                            $popup.css({ left: left + 'px',

                                         top: top + 'px'

                                       });

                            // prevent applying position

                            return false;

                           },

                    //showstatic: true,    // wanted on the toolbar

                    showselection: index == 2 ? true : false    // wanted on selection

                },

                insertimage: {

                    title: '插入图片',

                    image: '\uf030', // <img src="path/to/image.png" width="16" height="16" alt="" />

                    //showstatic: true,    // wanted on the toolbar

                    showselection: false    // wanted on selection

                },

                insertlink: {

                    title: '插入链接',

                    image: '\uf08e' // <img src="path/to/image.png" width="16" height="16" alt="" />

                },

                // Fontanme + Fontsize Plugin

                fontname: index == 1 ? false : {

                    title: '字体',

                    image: '\uf031', // <img src="path/to/image.png" width="16" height="16" alt="" />

                    popup: function( $popup, $button, $editor ) {

                            var list_fontnames = {

                                    // Name : Font

                                    'Arial, Helvetica' : 'Arial,Helvetica',

                                    'Verdana'          : 'Verdana,Geneva',

                                    'Georgia'          : 'Georgia',

                                    'Courier New'      : 'Courier New,Courier',

                                    'Times New Roman'  : 'Times New Roman,Times'

                                };

                            var $list = $('<div/>').addClass('wysiwyg-toolbar-list')

                                                   .attr('unselectable','on');

                            $.each( list_fontnames, function( name, font ){

                                var $link = $('<a/>').attr('href','#')

                                                    .css( 'font-family', font )

                                                    .html( name )

                                                    .click(function(event){

                                                        $(element).wysiwyg('fontname',font);

                                                        $(element).wysiwyg('close-popup');

                                                        // prevent link-href-#

                                                        event.stopPropagation();

                                                        event.preventDefault();

                                                        return false;

                                                    });

                                $list.append( $link );

                            });

                            $popup.append( $list );

                           },

                    //showstatic: true,    // wanted on the toolbar

                    showselection: index == 0 ? true : false    // wanted on selection

                },

                fontsize: index == 1 ? false : {

                    title: '尺寸',

                    image: '\uf034', // <img src="path/to/image.png" width="16" height="16" alt="" />

                    popup: function( $popup, $button, $editor ) {

                            var list_fontsizes = {

                                // Name : Size

                                'Huge'    : 7,

                                'Larger'  : 6,

                                'Large'   : 5,

                                'Normal'  : 4,

                                'Small'   : 3,

                                'Smaller' : 2,

                                'Tiny'    : 1

                            };

                            var $list = $('<div/>').addClass('wysiwyg-toolbar-list')

                                                   .attr('unselectable','on');

                            $.each( list_fontsizes, function( name, size ){

                                var $link = $('<a/>').attr('href','#')

                                                    .css( 'font-size', (8 + (size * 3)) + 'px' )

                                                    .html( name )

                                                    .click(function(event){

                                                        $(element).wysiwyg('fontsize',size);

                                                        $(element).wysiwyg('close-popup');

                                                        // prevent link-href-#

                                                        event.stopPropagation();

                                                        event.preventDefault();

                                                        return false;

                                                    });

                                $list.append( $link );

                            });

                            $popup.append( $list );

                           }

                    //showstatic: true,    // wanted on the toolbar

                    //showselection: true    // wanted on selection

                },

                bold: {

                    title: '加粗 (Ctrl+B)',

                    image: '\uf032', // <img src="path/to/image.png" width="16" height="16" alt="" />

                    hotkey: 'b'

                },

                italic: {

                    title: '斜体 (Ctrl+I)',

                    image: '\uf033', // <img src="path/to/image.png" width="16" height="16" alt="" />

                    hotkey: 'i'

                },

                underline: {

                    title: '下划线 (Ctrl+U)',

                    image: '\uf0cd', // <img src="path/to/image.png" width="16" height="16" alt="" />

                    hotkey: 'u'

                },

                strikethrough: {

                    title: '删除线 (Ctrl+S)',

                    image: '\uf0cc', // <img src="path/to/image.png" width="16" height="16" alt="" />

                    hotkey: 's'

                },

                forecolor: {

                    title: '文本颜色',

                    image: '\uf1fc' // <img src="path/to/image.png" width="16" height="16" alt="" />

                },

                highlight: {

                    title: '背景颜色',

                    image: '\uf043' // <img src="path/to/image.png" width="16" height="16" alt="" />

                },

                alignleft: index != 0 ? false : {

                    title: '左对齐',

                    image: '\uf036', // <img src="path/to/image.png" width="16" height="16" alt="" />

                    //showstatic: true,    // wanted on the toolbar

                    showselection: false    // wanted on selection

                },

                aligncenter: index != 0 ? false : {

                    title: '居中对齐',

                    image: '\uf037', // <img src="path/to/image.png" width="16" height="16" alt="" />

                    //showstatic: true,    // wanted on the toolbar

                    showselection: false    // wanted on selection

                },

                alignright: index != 0 ? false : {

                    title: '右对齐',

                    image: '\uf038', // <img src="path/to/image.png" width="16" height="16" alt="" />

                    //showstatic: true,    // wanted on the toolbar

                    showselection: false    // wanted on selection

                },

                alignjustify: index != 0 ? false : {

                    title: '两端对齐',

                    image: '\uf039', // <img src="path/to/image.png" width="16" height="16" alt="" />

                    //showstatic: true,    // wanted on the toolbar

                    showselection: false    // wanted on selection

                },

                subscript: index == 1 ? false : {

                    title: '下标',

                    image: '\uf12c', // <img src="path/to/image.png" width="16" height="16" alt="" />

                    //showstatic: true,    // wanted on the toolbar

                    showselection: true    // wanted on selection

                },

                superscript: index == 1 ? false : {

                    title: '上标',

                    image: '\uf12b', // <img src="path/to/image.png" width="16" height="16" alt="" />

                    //showstatic: true,    // wanted on the toolbar

                    showselection: true    // wanted on selection

                },

                indent: index != 0 ? false : {

                    title: '增加缩进量',

                    image: '\uf03c', // <img src="path/to/image.png" width="16" height="16" alt="" />

                    //showstatic: true,    // wanted on the toolbar

                    showselection: false    // wanted on selection

                },

                outdent: index != 0 ? false : {

                    title: '减少缩进量',

                    image: '\uf03b', // <img src="path/to/image.png" width="16" height="16" alt="" />

                    //showstatic: true,    // wanted on the toolbar

                    showselection: false    // wanted on selection

                },

                orderedList: index != 0 ? false : {

                    title: '编号',

                    image: '\uf0cb', // <img src="path/to/image.png" width="16" height="16" alt="" />

                    //showstatic: true,    // wanted on the toolbar

                    showselection: false    // wanted on selection

                },

                unorderedList: index != 0 ? false : {

                    title: '项目符号',

                    image: '\uf0ca', // <img src="path/to/image.png" width="16" height="16" alt="" />

                    //showstatic: true,    // wanted on the toolbar

                    showselection: false    // wanted on selection

                },

//                removeformat: {
//
//                    title: 'Remove format',
//
//                    image: '\uf12d' // <img src="path/to/image.png" width="16" height="16" alt="" />
//
//                }

            },

            // Submit-Button

            submit: {

                title: '提交',

                image: '\uf00c' // <img src="path/to/image.png" width="16" height="16" alt="" />

            },

            // Other properties

            dropfileclick: '请选择需要上传图片',

            placeholderUrl: 'www.example.com',

            maxImageSize: [600,200]

            /*

            onImageUpload: function( insert_image ) {

                            // Used to insert an image without XMLHttpRequest 2

                            // A bit tricky, because we can't easily upload a file

                            // via '$.ajax()' on a legacy browser.

                            // You have to submit the form into to a '<iframe/>' element.

                            // Call 'insert_image(url)' as soon as the file is online

                            // and the URL is available.

                            // Best way to do: http://malsup.com/jquery/form/

                            // For example:

                            //$(this).parents('form')

                            //       .attr('action','/path/to/file')

                            //       .attr('method','POST')

                            //       .attr('enctype','multipart/form-data')

                            //       .ajaxSubmit({

                            //          success: function(xhrdata,textStatus,jqXHR){

                            //            var image_url = xhrdata;

                            //            console.log( 'URL: ' + image_url );

                            //            insert_image( image_url );

                            //          }

                            //        });

                        },

            onKeyEnter: function() {

                            return false; // swallow enter

                        }

            */

        })

//        .change(function(){
//
//            if( typeof console != 'undefined' )
//
//                console.log( 'change' );
//
//        })
//
//        .focus(function(){
//
//            if( typeof console != 'undefined' )
//
//                console.log( 'focus' );
//
//        })
//
//        .blur(function(){
//
//            if( typeof console != 'undefined' )
//
//                console.log( 'blur' );
//
//        });

    });



    // Demo-Buttons

    $('#editor3-bold').click(function(){

        $('#editor3').wysiwyg('bold');

        return false;

    });

    $('#editor3-red').click(function(){

        $('#editor3').wysiwyg('highlight','#ff0000');

        return false;

    });

    $('#editor3-sethtml').click(function(){

        $('#editor3').wysiwyg('html', 'This is a the html text');

        return false;

    });

    $('#editor3-inserthtml').click(function(){

        $('#editor3').wysiwyg('inserthtml', 'This is some text');

        return false;

    });



    // Raw editor

//    var option = {
//
//        element: $('#editor0').get(0),
//
//        onkeypress: function( code, character, shiftKey, altKey, ctrlKey, metaKey ) {
//
//                        if( typeof console != 'undefined' )
//
//                            console.log( 'RAW: '+character+' key pressed' );
//
//                    },
//
//        onselection: function( collapsed, rect, nodes, rightclick ) {
//
//                        if( typeof console != 'undefined' && rect )
//
//                            console.log( 'RAW: selection rect('+rect.left+','+rect.top+','+rect.width+','+rect.height+'), '+nodes.length+' nodes' );
//
//                    },
//
//        onplaceholder: function( visible ) {
//
//                        if( typeof console != 'undefined' )
//
//                            console.log( 'RAW: placeholder ' + (visible ? 'visible' : 'hidden') );
//
//                    }
//
//    };

    //var wysiwygeditor = wysiwyg( option );

    //wysiwygeditor.setHTML( '<html>' );

});