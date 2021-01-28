# -*- coding: utf-8 -*-
# from odoo import http


# class Fashion(http.Controller):
#     @http.route('/fashion/fashion/', auth='public')
#     def index(self, **kw):
#         return "Hello, world"

#     @http.route('/fashion/fashion/objects/', auth='public')
#     def list(self, **kw):
#         return http.request.render('fashion.listing', {
#             'root': '/fashion/fashion',
#             'objects': http.request.env['fashion.fashion'].search([]),
#         })

#     @http.route('/fashion/fashion/objects/<model("fashion.fashion"):obj>/', auth='public')
#     def object(self, obj, **kw):
#         return http.request.render('fashion.object', {
#             'object': obj
#         })
