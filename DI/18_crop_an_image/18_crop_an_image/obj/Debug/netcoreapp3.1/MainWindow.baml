   M S B A M L   `   `   `  ����K  G18_crop_an_image, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null5clr-namespace:_18_crop_an_image_18_crop_an_image  5   	   U QSystem.Runtime, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a7,clr-namespace:System;assembly=System.RuntimeSystem 5   	   "    _18_crop_an_image.MainWindow   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   1localclr-namespace:_18_crop_an_image     5   	   ?System,clr-namespace:System;assembly=System.Runtime     5   	     � Title$  Trocear imagen��5	   	   $	��450��5
   	   $	��800��6    � WindowState$ 	Maximized=�6"    � 	Resources 5         margin_top_5  margin_5��%X   &	        &	 "     u�5   
   
0, 5, 0, 0q�65   u�5   
   
5, 5, 5, 5q�61   5      .��5      �  � ShowGridLines$ False��6    � ColumnDefinitions 5   
   �� 5      $
��0.5* �6   �� 5      $��2* �6    � RowDefinitions 5   
   �� 5      $��* �6   �� 5      $��0.30* �6   .+�5#   
   �� $
��Auto=�6   .��5$      �� -   5         ��Name$ 
spBotonera��5$       5'       �� 
TargetType �� Property	 �� Value��%R   '��       7   �� 5(      " ��6   .�5)      ��  � ��8	   63   5*      5+      .+�5.      �� -   5        
 ��Name$
 btnAutoLoadImage��5.      ��5/      X�50      50Q�6,   .��51   %   Cargar imágen52      �� 55      -   5        $
 btnManualLoadImage��55      ��56      X�57      50Q�6,   .��58   %   Selecciona imágen59      �� 5<      -   5        $
 btnCropImage��5<      ��5=      X�5>      50Q�6,   y�5@        System.Windows.Visibility 5A      	Collapsed=�60   .��5B   )   Trocear imágen5C      �� 5F      -   5        $
 btnCleanImages��5F      ��5G      X�5H      50Q�6,   .��5I   %   Limpiar contenido5J      5K      5L      � 5O   
   -   5         �Name$ gridLoadSelectedImage��5O      $��0��6.   $��1��6>   #��[ 6K   �� 5R   
   #��[ 6   $��1q�5S   ?   ���#000$��1��5U   )   $��2��5V   +   ._�5W      �� -   5         ��Name$ canvasLoadImage��5W      5X      5Y      5Z      