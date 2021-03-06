# -*- coding: utf-8 -*-
{
    'name': "vinos",

    'summary': """
        Módulo para adaptar el ERP a una bodega
    """,

    'description': """
        ¿Cansado de que no te funcionen los módulos?
        \n¿Necesitas soluciones rápidas?
        \n¿Estas leyendo esto con voz de comercial?
        \nPUES INSTALATE EL MÓDULO VINOS Y TU VIDA SE RESOLVERÁ (Bueno, tu vida no, pero ya me entiendes)
    """,

    'author': "Aarón Medina",
    'website': "https://github.com/Aaron-MedVil",

    # Categories can be used to filter modules in modules listing
    # Check https://github.com/odoo/odoo/blob/14.0/odoo/addons/base/data/ir_module_category_data.xml
    # for the full list
    'category': 'Uncategorized',
    'version': '0.1',

    # any module necessary for this one to work correctly
    'depends': ['base'],

    # always loaded
    'data': [
        'views/vinos.xml',
        'views/marcas.xml',
        'views/bodega.xml',
        'views/do.xml',
        'views/variedad.xml',
        'views/locDo.xml'
    ],
    # only loaded in demonstration mode
    'demo': [
        'demo/demo.xml',
    ],
}
