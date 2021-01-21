# -*- coding: utf-8 -*-
# from odoo import http


# class ModuloDePrueba(http.Controller):
#     @http.route('/modulo_de_prueba/modulo_de_prueba/', auth='public')
#     def index(self, **kw):
#         return "Hello, world"

#     @http.route('/modulo_de_prueba/modulo_de_prueba/objects/', auth='public')
#     def list(self, **kw):
#         return http.request.render('modulo_de_prueba.listing', {
#             'root': '/modulo_de_prueba/modulo_de_prueba',
#             'objects': http.request.env['modulo_de_prueba.modulo_de_prueba'].search([]),
#         })

#     @http.route('/modulo_de_prueba/modulo_de_prueba/objects/<model("modulo_de_prueba.modulo_de_prueba"):obj>/', auth='public')
#     def object(self, obj, **kw):
#         return http.request.render('modulo_de_prueba.object', {
#             'object': obj
#         })
