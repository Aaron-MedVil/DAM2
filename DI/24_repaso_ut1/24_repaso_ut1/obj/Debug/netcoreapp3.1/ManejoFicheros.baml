   M S B A M L   `   `   `  ����  24_repaso_ut1#    _24_repaso_ut1.ManejoFicheros   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   b ^MaterialDesignThemes.Wpf, Version=3.2.0.1979, Culture=neutral, PublicKeyToken=df2a72020bd7962a:md1http://materialdesigninxaml.net/winfx/xaml/themes  5   	   -   5          � Title$  ManejoFicheros��5   	   $	��450��5	   	   $	��800��6   $	��450��5
   	   $	��800��6   $	��450��5   	   $	��800��6    � 
ResizeMode$ NoResize=�5   	    � 	Resources 5       �� 
TargetType �� Property �� Value   
cmmGuardar �� Text �� InputGestures  cmmGuardarComo  cmmAbrir  cmmNuevo  cerrarVentana  commEliminar��%�  'o�       'm� �     '�� *    &	  �    &	     &	 i    &	 �    &	     &	 P    �� 5   
   " o�6   .�5      ��  � ��$	 800��6&   �� 5       � ��$ 20��6'   �� 5       � ��$	 Top=�62   5      �� 5   
   " m�6   .�5      ��  � ��$ Center=�62   �� 5       � ��$ Center=�64   �� 5       � ��$ 20��6'   5      �� 5   
   " ��6   .�5      ��  � ��$	 800��6&   �� 5       � ��$	 405��6'   �� 5       � ��$ 5, 10, 20, 50q�6(   5      �� 5    
   $  ��6-    5!      ��5"      
CTRL+S��6%   5$      �� 5%   
   $  ��61    5&      ��5'      CTRL+SHIFT+S��6+   5)      �� 5*   
   $  ��6+    5+      ��5,      
CTRL+A��6%   5.      �� 5/   
   $  ��6+    50      ��51      
CTRL+N��6%   53      �� 54   
   $  ��60    55      ��56      ESC��6"   58      �� 59   
   $  ��6/    5:      ��5;      CTRL+ESC��6'   5=      5>       J� CommandBindings 5@      )  #System.Windows.Input.CommandBinding  5A   
   -   5        	   Command#	 [  5A      6?     5B   
   -   5        #	 [ 5B      6C     5C   
   -   5        #	 [ 5C      6=     5D   
   -   5        #	 [ 5D      6=     5E   
   -   5        #	 [ 5E      6B     5F   
   -   5        #	 [ 5F      6A   .��5H      �� .+�5K   
   o� .@�5L      m� 
 m� Command#
 [  6?   ��6   0  *MaterialDesignThemes.Wpf.PackIconExtension     Kind$ ContentSave=�6?   m� 5M      #
 [ 6B   ��6     $ ContentSaveAll=�6B   m� 5N      #
 [ 6:   ��6     $ Folder=�6:   m� 5O      #
 [ 6@   ��6     $ FileDocument=�6@   m� 5P      #
 [ 6:   ��6     $ Delete=�6:   m� 5Q      #
 [ 69   ��6     $ Close=�69   5R      �� 5U   
   -   5         ��Name$ 
textEditor��5U      . �5V      /� .T�5W      J� .*�6   .*�5X      �� .�6   
Bienvenido6&   5Y      5Z      5[      5\      5]      