   M S B A M L   `   `   `  ����  20_editor_texto!    _20_editor_texto.MainWindow   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   b ^MaterialDesignThemes.Wpf, Version=3.2.0.1979, Culture=neutral, PublicKeyToken=df2a72020bd7962a;mdt1http://materialdesigninxaml.net/winfx/xaml/themes  5   	   X TXceed.Wpf.Toolkit, Version=4.0.0.0, Culture=neutral, PublicKeyToken=3e4669d2f30244f45xctkl)http://schemas.xceed.com/wpf/xaml/toolkit  5   	   -   5          � Title$  Editor de texto��5	   	   $	��450��6!   $	��800��61    � WindowState$ 	Maximized=�5
   	    � 	Resources 5       �� 
TargetType �� Property �� Value   nuevoDocumento �� Text �� InputGestures  salirPrograma  guardarDocumento  abrirDocumento  imprimirDocumento  toggleBoldText  toggleItalicText  toggleUnderlineText  	showAyuda��%�  'm�       '�� G     '�� �     '�� 0    &	  �    &	 �    &	 7    &	 �    &	 �    &	 !    &	 o    &	 �    &	     �� 5   
   " m�6   .�5      ��  � ��$ 5q�6(   5      �� 5   
   " ��6   .�5      ��  � ��$	 Top=�62   �� 5       � ��$ 
5, 0, 0, 0q�6'   5      �� 5   
   " ��6   .�5      ��  � ��$ Center=�62   �� 5       � ��$ Center=�64   5      �� 5   
   " ��6   .�5      ��  � �� �#0006,   �� 5       � ��$ 1q�60   5      �� 5!   
   $  ��61    5"      ��5#      
CTRL+N��6%   5%      �� 5&   
   $  ��60    5'      ��5(      ESC��6"   5*      �� 5+   
   $  ��63    5,      ��5-      
CTRL+S��6%   5/      �� 50   
   $  ��61    51      ��52      
CTRL+A��6%   54      �� 55   
   $  ��64    56      ��57      
CTRL+P��6%   59      �� 5:   
   $  ��61    5;      ��5<      
CTRL+K��6%   5>      �� 5?   
   $  ��63    5@      ��5A      
CTRL+I��6%   5C      �� 5D   
   $  ��66    5E      ��5F      
CTRL+U��6%   5H      �� 5I   
   $  ��6,    5J      ��5K      F1��6!   5M      5N       J� CommandBindings 5Q      )  #System.Windows.Input.CommandBinding  5R   
   -   5        	   Command#	 [  5R      6C     5S   
   -   5        #	 [ 5S      6E     5T   
   -   5        #	 [ 5T      6B     5U   
   -   5        #	 [ 5U      6F     5V   
   -   5        #	 [ 5V      6C     5W   
   -   5        #	 [ 5W      6C     5X   
   -   5        #	 [ 5X      6E     5Y   
   -	   5        #	 [ 5Y      6H     5Z   
   -
   5        #	 [ 5Z      6>   .��5\      � 
 � RowDefinitions
 5_   
   �� 5`      $��* �6   �� 5a      $��* �6   �� 5b      $	��20* �6   �� 5c      $��* �6   .+�5g   
   �� $��0��6   $��
0, 5, 0, 0q�6"   .+�5h      o� -   5         o�Name$ menuSuperior��5h      ��5j      �� 5k       �� Path$ ActualWidth�6    �� RelativeSource 61   �� *FindAncestor+ �� AncestorType" ����5m      �� 5n      $ ActualHeight�6    62   �� *FindAncestor+" ��.@�5r      m� $��_Fichero��6   .@�5u      m� $��_Nuevo��6    m� Command# [  6/    m� Icon 5v      '  !MaterialDesignThemes.Wpf.PackIcon  5w         Kind$ FileDocument=�6+   5y      m� 5|      $��_Guardar��6   # [ 61    5}        5~      $ ContentSave=�6+   5�      m� 5�      $��_Abrir��6   # [ 6/    5�        5�      $ 
FolderOpen=�6+   5�      m� 5�      $��	_Imprimir��6   # [ 62    5�        5�      $ Printer=�6+   5�      5�      m� 5�      $��_Formato��6   .@�5�      m� $��Copiar��6   $ ApplicationCommands.Copy��6/    5�        5�      $ ContentCopy=�6+   5�      m� 5�      $��Cortar��6   $ ApplicationCommands.Cut��6/    5�        5�      $ 
ContentCut=�6+   5�      m� 5�      $��Pegar��6   $ ApplicationCommands.Paste��6.    5�        5�      $ ContentPaste=�6+   5�      5�      m� 5�      $��_Ventana��6   .@�5�      m� -   5         m�Name$ miChangeEditorBackground��5�   G   $��
Modo noche��6   $y�	Collapsed=�6i    6�   0  *MaterialDesignThemes.Wpf.PackIconExtension     Kind$ ThemeLightDark=�m� 5�      -   5        $ miFullScreen��5�   S   $��Pantalla completa��6    5�        5�      $ 
Fullscreen=�6+   5�      5�      m� 5�      -   5        $ miItemVarios��5�      $��_Varios��61   .@�5�      m� -   5        $��Corrección ortográfica��5�       6X     $ 
Dictionary=�m� 5�      $��Ayuda��6   # [ 6.    6S     $
 Help=�m� 5�      -   5        $��Buscar/Reemplazar��5�       6W     $ Search=�5�      5�      5�      �� 5�   
   $��1��5�   #   .+�5�      o� ��5�      �� 5�      $ ActualWidth�6    61   �� *FindAncestor+" ����5�      �� 5�      $ ActualHeight�6    62   �� *FindAncestor+" ��.@�5�      m� $��Negrita��6   # [ 6,    6V     $ 
FormatBold=�m� 5�      $��Cursiva��6   # [ 6,    6X     $ FormatItalic=�m� 5�      $��	Subrayado��6   # [ 6.    6]     $ FormatUnderline=��� 5�      -   5         ��Name$ 
cbFontSize��5�      6/   �� 5�      -   5        $ 
cbFontType��5�      6/   #  Xceed.Wpf.Toolkit.ColorPicker  5�      -   5          Name$ selectorColor��5�   $   6;   5�      5�      � 5�   
   $��2��6   $��
5, 0, 5, 5q�6   .+�5�      �� -   5         ��Name$ 	cajaTexto��5�      ��5�      �� 5�      $ ActualWidth�6    61   �� *FindAncestor+" �. �5�      /� .T�5�      J� .*�6    .*�5�      �� $� ��6   5�      5�      5�      5�      �� 5�   
   $��2��6   6$   5�      5�      