# -*- coding: utf-8 -*-
# from odoo import http


# class PruebaMod(http.Controller):
#     @http.route('/prueba_mod/prueba_mod/', auth='public')
#     def index(self, **kw):
#         return "Hello, world"

#     @http.route('/prueba_mod/prueba_mod/objects/', auth='public')
#     def list(self, **kw):
#         return http.request.render('prueba_mod.listing', {
#             'root': '/prueba_mod/prueba_mod',
#             'objects': http.request.env['prueba_mod.prueba_mod'].search([]),
#         })

#     @http.route('/prueba_mod/prueba_mod/objects/<model("prueba_mod.prueba_mod"):obj>/', auth='public')
#     def object(self, obj, **kw):
#         return http.request.render('prueba_mod.object', {
#             'object': obj
#         })
